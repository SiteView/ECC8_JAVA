// **********************************************************************
//
// Copyright (c) 2003-2009 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

// Ice version 3.3.1

package SliceScasvapi;

public final class ForestListHelper
{
    public static void
    write(IceInternal.BasicStream __os, java.util.Map<java.lang.String, java.lang.String>[] __v)
    {
        if(__v == null)
        {
            __os.writeSize(0);
        }
        else
        {
            __os.writeSize(__v.length);
            for(int __i0 = 0; __i0 < __v.length; __i0++)
            {
                NodeDataHelper.write(__os, __v[__i0]);
            }
        }
    }

    public static java.util.Map<java.lang.String, java.lang.String>[]
    read(IceInternal.BasicStream __is)
    {
        java.util.Map<java.lang.String, java.lang.String>[] __v;
        final int __len0 = __is.readSize();
        __is.startSeq(__len0, 1);
        __v = (java.util.Map<java.lang.String, java.lang.String>[])new java.util.Map[__len0];
        for(int __i0 = 0; __i0 < __len0; __i0++)
        {
            __v[__i0] = NodeDataHelper.read(__is);
            __is.checkSeq();
            __is.endElement();
        }
        __is.endSeq(__len0);
        return __v;
    }
}
