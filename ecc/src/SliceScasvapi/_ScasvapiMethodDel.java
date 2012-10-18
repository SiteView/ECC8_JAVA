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

public interface _ScasvapiMethodDel extends Ice._ObjectDel
{
    boolean SliceGetUnivData(java.util.Map<java.lang.String, java.lang.String> inwhat, SForestMapHolder fmap, Ice.StringHolder estr, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    boolean SliceSubmitUnivData(java.util.Map<java.lang.String, java.lang.String> inwhat, java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.String>> ifmap, SForestMapHolder ofmap, Ice.StringHolder estr, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    boolean SliceGetForestData(java.util.Map<java.lang.String, java.lang.String> inwhat, SForestListHolder flist, Ice.StringHolder estr, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    void shutdown(java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;
}
