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

public final class ScasvapiMethodPrxHelper extends Ice.ObjectPrxHelperBase implements ScasvapiMethodPrx
{
    public boolean
    SliceGetForestData(java.util.Map<java.lang.String, java.lang.String> inwhat, SForestListHolder flist, Ice.StringHolder estr)
    {
        return SliceGetForestData(inwhat, flist, estr, null, false);
    }

    public boolean
    SliceGetForestData(java.util.Map<java.lang.String, java.lang.String> inwhat, SForestListHolder flist, Ice.StringHolder estr, java.util.Map<String, String> __ctx)
    {
        return SliceGetForestData(inwhat, flist, estr, __ctx, true);
    }

    @SuppressWarnings("unchecked")
    private boolean
    SliceGetForestData(java.util.Map<java.lang.String, java.lang.String> inwhat, SForestListHolder flist, Ice.StringHolder estr, java.util.Map<String, String> __ctx, boolean __explicitCtx)
    {
        if(__explicitCtx && __ctx == null)
        {
            __ctx = _emptyContext;
        }
        int __cnt = 0;
        while(true)
        {
            Ice._ObjectDel __delBase = null;
            try
            {
                __checkTwowayOnly("SliceGetForestData");
                __delBase = __getDelegate(false);
                _ScasvapiMethodDel __del = (_ScasvapiMethodDel)__delBase;
                return __del.SliceGetForestData(inwhat, flist, estr, __ctx);
            }
            catch(IceInternal.LocalExceptionWrapper __ex)
            {
                __cnt = __handleExceptionWrapperRelaxed(__delBase, __ex, null, __cnt);
            }
            catch(Ice.LocalException __ex)
            {
                __cnt = __handleException(__delBase, __ex, null, __cnt);
            }
        }
    }

    public boolean
    SliceGetUnivData(java.util.Map<java.lang.String, java.lang.String> inwhat, SForestMapHolder fmap, Ice.StringHolder estr)
    {
        return SliceGetUnivData(inwhat, fmap, estr, null, false);
    }

    public boolean
    SliceGetUnivData(java.util.Map<java.lang.String, java.lang.String> inwhat, SForestMapHolder fmap, Ice.StringHolder estr, java.util.Map<String, String> __ctx)
    {
        return SliceGetUnivData(inwhat, fmap, estr, __ctx, true);
    }

    @SuppressWarnings("unchecked")
    private boolean
    SliceGetUnivData(java.util.Map<java.lang.String, java.lang.String> inwhat, SForestMapHolder fmap, Ice.StringHolder estr, java.util.Map<String, String> __ctx, boolean __explicitCtx)
    {
        if(__explicitCtx && __ctx == null)
        {
            __ctx = _emptyContext;
        }
        int __cnt = 0;
        while(true)
        {
            Ice._ObjectDel __delBase = null;
            try
            {
                __checkTwowayOnly("SliceGetUnivData");
                __delBase = __getDelegate(false);
                _ScasvapiMethodDel __del = (_ScasvapiMethodDel)__delBase;
                return __del.SliceGetUnivData(inwhat, fmap, estr, __ctx);
            }
            catch(IceInternal.LocalExceptionWrapper __ex)
            {
                __cnt = __handleExceptionWrapperRelaxed(__delBase, __ex, null, __cnt);
            }
            catch(Ice.LocalException __ex)
            {
                __cnt = __handleException(__delBase, __ex, null, __cnt);
            }
        }
    }

    public boolean
    SliceSubmitUnivData(java.util.Map<java.lang.String, java.lang.String> inwhat, java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.String>> ifmap, SForestMapHolder ofmap, Ice.StringHolder estr)
    {
        return SliceSubmitUnivData(inwhat, ifmap, ofmap, estr, null, false);
    }

    public boolean
    SliceSubmitUnivData(java.util.Map<java.lang.String, java.lang.String> inwhat, java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.String>> ifmap, SForestMapHolder ofmap, Ice.StringHolder estr, java.util.Map<String, String> __ctx)
    {
        return SliceSubmitUnivData(inwhat, ifmap, ofmap, estr, __ctx, true);
    }

    @SuppressWarnings("unchecked")
    private boolean
    SliceSubmitUnivData(java.util.Map<java.lang.String, java.lang.String> inwhat, java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.String>> ifmap, SForestMapHolder ofmap, Ice.StringHolder estr, java.util.Map<String, String> __ctx, boolean __explicitCtx)
    {
        if(__explicitCtx && __ctx == null)
        {
            __ctx = _emptyContext;
        }
        int __cnt = 0;
        while(true)
        {
            Ice._ObjectDel __delBase = null;
            try
            {
                __checkTwowayOnly("SliceSubmitUnivData");
                __delBase = __getDelegate(false);
                _ScasvapiMethodDel __del = (_ScasvapiMethodDel)__delBase;
                return __del.SliceSubmitUnivData(inwhat, ifmap, ofmap, estr, __ctx);
            }
            catch(IceInternal.LocalExceptionWrapper __ex)
            {
                __cnt = __handleExceptionWrapperRelaxed(__delBase, __ex, null, __cnt);
            }
            catch(Ice.LocalException __ex)
            {
                __cnt = __handleException(__delBase, __ex, null, __cnt);
            }
        }
    }

    public void
    shutdown()
    {
        shutdown(null, false);
    }

    public void
    shutdown(java.util.Map<String, String> __ctx)
    {
        shutdown(__ctx, true);
    }

    @SuppressWarnings("unchecked")
    private void
    shutdown(java.util.Map<String, String> __ctx, boolean __explicitCtx)
    {
        if(__explicitCtx && __ctx == null)
        {
            __ctx = _emptyContext;
        }
        int __cnt = 0;
        while(true)
        {
            Ice._ObjectDel __delBase = null;
            try
            {
                __delBase = __getDelegate(false);
                _ScasvapiMethodDel __del = (_ScasvapiMethodDel)__delBase;
                __del.shutdown(__ctx);
                return;
            }
            catch(IceInternal.LocalExceptionWrapper __ex)
            {
                __cnt = __handleExceptionWrapperRelaxed(__delBase, __ex, null, __cnt);
            }
            catch(Ice.LocalException __ex)
            {
                __cnt = __handleException(__delBase, __ex, null, __cnt);
            }
        }
    }

    public static ScasvapiMethodPrx
    checkedCast(Ice.ObjectPrx __obj)
    {
        ScasvapiMethodPrx __d = null;
        if(__obj != null)
        {
            try
            {
                __d = (ScasvapiMethodPrx)__obj;
            }
            catch(ClassCastException ex)
            {
                if(__obj.ice_isA("::SliceScasvapi::ScasvapiMethod"))
                {
                    ScasvapiMethodPrxHelper __h = new ScasvapiMethodPrxHelper();
                    __h.__copyFrom(__obj);
                    __d = __h;
                }
            }
        }
        return __d;
    }

    public static ScasvapiMethodPrx
    checkedCast(Ice.ObjectPrx __obj, java.util.Map<String, String> __ctx)
    {
        ScasvapiMethodPrx __d = null;
        if(__obj != null)
        {
            try
            {
                __d = (ScasvapiMethodPrx)__obj;
            }
            catch(ClassCastException ex)
            {
                if(__obj.ice_isA("::SliceScasvapi::ScasvapiMethod", __ctx))
                {
                    ScasvapiMethodPrxHelper __h = new ScasvapiMethodPrxHelper();
                    __h.__copyFrom(__obj);
                    __d = __h;
                }
            }
        }
        return __d;
    }

    public static ScasvapiMethodPrx
    checkedCast(Ice.ObjectPrx __obj, String __facet)
    {
        ScasvapiMethodPrx __d = null;
        if(__obj != null)
        {
            Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
            try
            {
                if(__bb.ice_isA("::SliceScasvapi::ScasvapiMethod"))
                {
                    ScasvapiMethodPrxHelper __h = new ScasvapiMethodPrxHelper();
                    __h.__copyFrom(__bb);
                    __d = __h;
                }
            }
            catch(Ice.FacetNotExistException ex)
            {
            }
        }
        return __d;
    }

    public static ScasvapiMethodPrx
    checkedCast(Ice.ObjectPrx __obj, String __facet, java.util.Map<String, String> __ctx)
    {
        ScasvapiMethodPrx __d = null;
        if(__obj != null)
        {
            Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
            try
            {
                if(__bb.ice_isA("::SliceScasvapi::ScasvapiMethod", __ctx))
                {
                    ScasvapiMethodPrxHelper __h = new ScasvapiMethodPrxHelper();
                    __h.__copyFrom(__bb);
                    __d = __h;
                }
            }
            catch(Ice.FacetNotExistException ex)
            {
            }
        }
        return __d;
    }

    public static ScasvapiMethodPrx
    uncheckedCast(Ice.ObjectPrx __obj)
    {
        ScasvapiMethodPrx __d = null;
        if(__obj != null)
        {
            try
            {
                __d = (ScasvapiMethodPrx)__obj;
            }
            catch(ClassCastException ex)
            {
                ScasvapiMethodPrxHelper __h = new ScasvapiMethodPrxHelper();
                __h.__copyFrom(__obj);
                __d = __h;
            }
        }
        return __d;
    }

    public static ScasvapiMethodPrx
    uncheckedCast(Ice.ObjectPrx __obj, String __facet)
    {
        ScasvapiMethodPrx __d = null;
        if(__obj != null)
        {
            Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
            ScasvapiMethodPrxHelper __h = new ScasvapiMethodPrxHelper();
            __h.__copyFrom(__bb);
            __d = __h;
        }
        return __d;
    }

    protected Ice._ObjectDelM
    __createDelegateM()
    {
        return new _ScasvapiMethodDelM();
    }

    protected Ice._ObjectDelD
    __createDelegateD()
    {
        return new _ScasvapiMethodDelD();
    }

    public static void
    __write(IceInternal.BasicStream __os, ScasvapiMethodPrx v)
    {
        __os.writeProxy(v);
    }

    public static ScasvapiMethodPrx
    __read(IceInternal.BasicStream __is)
    {
        Ice.ObjectPrx proxy = __is.readProxy();
        if(proxy != null)
        {
            ScasvapiMethodPrxHelper result = new ScasvapiMethodPrxHelper();
            result.__copyFrom(proxy);
            return result;
        }
        return null;
    }
}
