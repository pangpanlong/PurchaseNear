package cn.purchasenear.v1.cart.ice.impl;

import org.purchasenear.common.ice.server.AbstractIceBoxService;

/**
 * @Author:Pengd
 * @Date:2015/8/31 13:21
 * Copyright (c) 2014, liangceNetwork All Rights Reserved.
 */
public class PurchaseCartIceService extends AbstractIceBoxService {
    @Override
    public Ice.Object createMyIceServiceObj(String[] args) {
        Ice.Object object = new PurchaseCartIceServiceI();
        return object;
    }
}
