// **********************************************************************
//
// Copyright (c) 2003-2013 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************
//
// Ice version 3.5.1
//
// <auto-generated>
//
// Generated from file `GoodsService.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package cn.purchasenear.v1.goods.rpcservice.ice.interf.goods;

public class GoodsInfo implements java.lang.Cloneable, java.io.Serializable
{
    public long goodsId;

    public String goodsName;

    public String sellerName;

    public long category;

    public int band;

    public int stock;

    public double price;

    public double logintitude;

    public double latitude;

    public String address;

    public int hypostatic;

    public int deliver;

    public int secondHand;

    public int barter;

    public double distance;

    public GoodsInfo()
    {
    }

    public GoodsInfo(long goodsId, String goodsName, String sellerName, long category, int band, int stock, double price, double logintitude, double latitude, String address, int hypostatic, int deliver, int secondHand, int barter, double distance)
    {
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.sellerName = sellerName;
        this.category = category;
        this.band = band;
        this.stock = stock;
        this.price = price;
        this.logintitude = logintitude;
        this.latitude = latitude;
        this.address = address;
        this.hypostatic = hypostatic;
        this.deliver = deliver;
        this.secondHand = secondHand;
        this.barter = barter;
        this.distance = distance;
    }

    public boolean
    equals(java.lang.Object rhs)
    {
        if(this == rhs)
        {
            return true;
        }
        GoodsInfo _r = null;
        if(rhs instanceof GoodsInfo)
        {
            _r = (GoodsInfo)rhs;
        }

        if(_r != null)
        {
            if(goodsId != _r.goodsId)
            {
                return false;
            }
            if(goodsName != _r.goodsName)
            {
                if(goodsName == null || _r.goodsName == null || !goodsName.equals(_r.goodsName))
                {
                    return false;
                }
            }
            if(sellerName != _r.sellerName)
            {
                if(sellerName == null || _r.sellerName == null || !sellerName.equals(_r.sellerName))
                {
                    return false;
                }
            }
            if(category != _r.category)
            {
                return false;
            }
            if(band != _r.band)
            {
                return false;
            }
            if(stock != _r.stock)
            {
                return false;
            }
            if(price != _r.price)
            {
                return false;
            }
            if(logintitude != _r.logintitude)
            {
                return false;
            }
            if(latitude != _r.latitude)
            {
                return false;
            }
            if(address != _r.address)
            {
                if(address == null || _r.address == null || !address.equals(_r.address))
                {
                    return false;
                }
            }
            if(hypostatic != _r.hypostatic)
            {
                return false;
            }
            if(deliver != _r.deliver)
            {
                return false;
            }
            if(secondHand != _r.secondHand)
            {
                return false;
            }
            if(barter != _r.barter)
            {
                return false;
            }
            if(distance != _r.distance)
            {
                return false;
            }

            return true;
        }

        return false;
    }

    public int
    hashCode()
    {
        int __h = 5381;
        __h = IceInternal.HashUtil.hashAdd(__h, "::goods::GoodsInfo");
        __h = IceInternal.HashUtil.hashAdd(__h, goodsId);
        __h = IceInternal.HashUtil.hashAdd(__h, goodsName);
        __h = IceInternal.HashUtil.hashAdd(__h, sellerName);
        __h = IceInternal.HashUtil.hashAdd(__h, category);
        __h = IceInternal.HashUtil.hashAdd(__h, band);
        __h = IceInternal.HashUtil.hashAdd(__h, stock);
        __h = IceInternal.HashUtil.hashAdd(__h, price);
        __h = IceInternal.HashUtil.hashAdd(__h, logintitude);
        __h = IceInternal.HashUtil.hashAdd(__h, latitude);
        __h = IceInternal.HashUtil.hashAdd(__h, address);
        __h = IceInternal.HashUtil.hashAdd(__h, hypostatic);
        __h = IceInternal.HashUtil.hashAdd(__h, deliver);
        __h = IceInternal.HashUtil.hashAdd(__h, secondHand);
        __h = IceInternal.HashUtil.hashAdd(__h, barter);
        __h = IceInternal.HashUtil.hashAdd(__h, distance);
        return __h;
    }

    public java.lang.Object
    clone()
    {
        java.lang.Object o = null;
        try
        {
            o = super.clone();
        }
        catch(CloneNotSupportedException ex)
        {
            assert false; // impossible
        }
        return o;
    }

    public void
    __write(IceInternal.BasicStream __os)
    {
        __os.writeLong(goodsId);
        __os.writeString(goodsName);
        __os.writeString(sellerName);
        __os.writeLong(category);
        __os.writeInt(band);
        __os.writeInt(stock);
        __os.writeDouble(price);
        __os.writeDouble(logintitude);
        __os.writeDouble(latitude);
        __os.writeString(address);
        __os.writeInt(hypostatic);
        __os.writeInt(deliver);
        __os.writeInt(secondHand);
        __os.writeInt(barter);
        __os.writeDouble(distance);
    }

    public void
    __read(IceInternal.BasicStream __is)
    {
        goodsId = __is.readLong();
        goodsName = __is.readString();
        sellerName = __is.readString();
        category = __is.readLong();
        band = __is.readInt();
        stock = __is.readInt();
        price = __is.readDouble();
        logintitude = __is.readDouble();
        latitude = __is.readDouble();
        address = __is.readString();
        hypostatic = __is.readInt();
        deliver = __is.readInt();
        secondHand = __is.readInt();
        barter = __is.readInt();
        distance = __is.readDouble();
    }

    public void
    ice_write(Ice.OutputStream __outS)
    {
        __outS.writeLong(goodsId);
        __outS.writeString(goodsName);
        __outS.writeString(sellerName);
        __outS.writeLong(category);
        __outS.writeInt(band);
        __outS.writeInt(stock);
        __outS.writeDouble(price);
        __outS.writeDouble(logintitude);
        __outS.writeDouble(latitude);
        __outS.writeString(address);
        __outS.writeInt(hypostatic);
        __outS.writeInt(deliver);
        __outS.writeInt(secondHand);
        __outS.writeInt(barter);
        __outS.writeDouble(distance);
    }

    public void
    ice_read(Ice.InputStream __inS)
    {
        goodsId = __inS.readLong();
        goodsName = __inS.readString();
        sellerName = __inS.readString();
        category = __inS.readLong();
        band = __inS.readInt();
        stock = __inS.readInt();
        price = __inS.readDouble();
        logintitude = __inS.readDouble();
        latitude = __inS.readDouble();
        address = __inS.readString();
        hypostatic = __inS.readInt();
        deliver = __inS.readInt();
        secondHand = __inS.readInt();
        barter = __inS.readInt();
        distance = __inS.readDouble();
    }

    public static final long serialVersionUID = 604861619L;
}
