package io.daff.oishii.member.service.impl;

import io.daff.oishii.member.entity.po.PointTransPO;
import io.daff.oishii.member.entity.vo.LevelBenefitsVO;
import io.daff.oishii.member.entity.vo.UserLevelInfoVO;
import io.daff.oishii.member.mapper.LevelMapper;
import io.daff.oishii.member.mapper.PointTransMapper;
import io.daff.oishii.member.mapper.UserLevelHistoryMapper;
import io.daff.oishii.member.service.LevelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author daff
 * @since 2023/5/8
 */
@Service
public class LevelServiceImpl implements LevelService {

    @Resource
    private LevelMapper levelMapper;
    @Resource
    private UserLevelHistoryMapper userLevelHistoryMapper;
    @Resource
    private PointTransMapper pointTransMapper;

    @Override
    public List<LevelBenefitsVO> listMerchantLevelBenefits(String merchantCode) {
        return levelMapper.selectByMerchantCode(merchantCode);
    }

    @Override
    public UserLevelInfoVO getUserLevelInfo(String userCode) {
        UserLevelInfoVO userLevelInfoVO = userLevelHistoryMapper.selectLevelByUserCode(userCode);
        List<PointTransPO> pointList = pointTransMapper.selectPoints(userLevelInfoVO.getUserCode(), userLevelInfoVO.getUpgradeTime());
        int newPoints = (int) pointList.stream().collect(Collectors.summarizingInt(PointTransPO::getPoint)).getSum();
        userLevelInfoVO.setPoints(userLevelInfoVO.getPoints() + newPoints);
        return userLevelInfoVO;
    }
}
