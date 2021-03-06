package org.wheatgenetics.androidlibraryuser.mstrdtl;

/**
 * Uses:
 * androidx.annotation.RestrictTo
 * androidx.annotation.RestrictTo.Scope
 *
 * org.wheatgenetics.javalib.mstrdtl.Items
 *
 * org.wheatgenetics.androidlibrary.mstrdtl.OnePaneAdapter
 *
 * org.wheatgenetics.androidlibraryuser.mstrdtl.ItemActivity
 */
class OnePaneAdapter extends org.wheatgenetics.androidlibrary.mstrdtl.OnePaneAdapter
{
    OnePaneAdapter(final org.wheatgenetics.javalib.mstrdtl.Items items) { super(items); }

    @androidx.annotation.RestrictTo(androidx.annotation.RestrictTo.Scope.SUBCLASSES)
    @java.lang.Override protected java.lang.Class concreteItemActivityClass()
    { return org.wheatgenetics.androidlibraryuser.mstrdtl.ItemActivity.class; }
}