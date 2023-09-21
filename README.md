# oishii

## 项目简介
类似电商项目，根据自身经验和学习整合

## 项目模块

所有模块均为web项目。
- oishii-common：所有模块的公共模块
- oishii-console：后台配置端
- oishii-member：开放用户端

## 一些约定

- 每个模块的接口分为对外使用和对内使用。对内使用就是供本项目的其他模块使用，这些api放在xxxProvider包下，类名是xxxProvider形式的。提供给外部使用的接口为对外接口，对外接口一般放在api包下，类名以Api结尾。