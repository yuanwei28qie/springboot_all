package com.study.cn.springbootall.constans;

/**
 * @author huWei
 * @date 2019/7/21 12:21
 * <p> description:
 */
public enum  RelationShipType {
    /**
     * 关系为妈妈
     */
    Mom("母亲",0),
    /**
     * 姐姐
     */
    SISTER("姐姐",1),
    /**
     * 兄弟
     */
    BROTHER("兄弟",2),
    /**
     * 儿子
     */
    SON("儿子",3),
    /**
     * 女儿
     */
    DAUGHTER("女儿",4),
    /**
     * 父亲
     */
    FATHER("父亲",5);


    RelationShipType(String name, Integer relationShipType) {
        this.name = name;
        this.relationShipType = relationShipType;
    }

    private String name;

    private Integer relationShipType;


}