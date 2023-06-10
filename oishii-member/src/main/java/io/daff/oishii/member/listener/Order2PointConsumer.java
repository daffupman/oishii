package io.daff.oishii.member.listener;

import io.daff.logging.DaffLogger;
import io.daff.oishii.common.enums.BaseModule;
import io.daff.oishii.common.util.JacksonUtil;
import io.daff.oishii.member.entity.po.PointTransPO;
import io.daff.oishii.member.mapper.PointTransMapper;
import io.daff.oishii.member.thirdpart.vo.OrderVO;
import io.daff.utils.common.StringUtil;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 监听订单消息
 *
 * @author daff
 * @since 2023/5/10
 */
@Component
public class Order2PointConsumer {

    private static final DaffLogger logger = DaffLogger.getLogger(Order2PointConsumer.class);

    @Resource
    private PointTransMapper pointTransMapper;

    @KafkaListener(id = "member", topics = {"order2point"})
    public void handle(String rawMessage) {

        logger.info("receive msg from kafka: {}", BaseModule.MEMBER, rawMessage);
        if (!StringUtil.hasText(rawMessage)) {
            return;
        }

        OrderVO orderVO = JacksonUtil.stringToBean(rawMessage, OrderVO.class);
        PointTransPO transPO = orderVO2PointTrans(orderVO);
        pointTransMapper.insert(transPO);
    }

    private PointTransPO orderVO2PointTrans(OrderVO orderVO) {
        PointTransPO transPO = new PointTransPO();
        transPO.setOrderNo(orderVO.getOrderNo());
        transPO.setUserCode(orderVO.getUserCode());
        transPO.setPoint(orderVO.getPayAmount() / 100);
        transPO.setCreateTime(new Date());
        return transPO;
    }
}
