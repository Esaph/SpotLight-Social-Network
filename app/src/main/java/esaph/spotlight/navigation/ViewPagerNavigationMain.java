/*
 *  Copyright (C) Esaph, Julian Auguscik - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *  * Written by Julian Auguscik <esaph.re@gmail.com>, March  2020
 *
 */

package esaph.spotlight.navigation;

import android.content.Context;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import esaph.spotlight.EsaphGlobalCommunicationFragment;
import esaph.spotlight.navigation.navigationRightSite.FragmentNavigationRightSite;

public class ViewPagerNavigationMain extends FragmentStatePagerAdapter
{
    public static final int POSITION_CAMERA = 0;
    public static final int POSITION_SPOTLIGHT = 1;

    private EsaphGlobalCommunicationFragment currentFragment = null;
    private FragmentNavigationRightSite fragmentNavigationRightSite;
    private static int PageCount = 2;
    private EmptyFragment emptyFragment;
    private FragmentManager fragmentManager;
    private Context context;

    public FragmentNavigationRightSite getFragmentNavigationRightSite() {
        return fragmentNavigationRightSite;
    }

    @Override
    public void setPrimaryItem(@NonNull ViewGroup container, int position, Object object)
    {
        if (getCurrentFragment() != object)
        {
            currentFragment = ((EsaphGlobalCommunicationFragment) object);
        }
        super.setPrimaryItem(container, position, object);
    }

    public EsaphGlobalCommunicationFragment getCurrentFragment()
    {
        return currentFragment;
    }

    public ViewPagerNavigationMain(FragmentManager manager, Context context)
    {
        super(manager);
        this.fragmentManager = manager;
        this.emptyFragment = new EmptyFragment();
        this.context = context;
    }

    private boolean sendInfoEnabled = false;

    public void setUpDialogSendInfo()
    {
        sendInfoEnabled = true;
    }

    public void removePreviewFragment()
    {
        sendInfoEnabled = false;
    }

    public boolean isSendInfoEnabled()
    {
        return sendInfoEnabled;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position)
    {
        return null;
    }

    @Override
    public Fragment getItem(int position)
    {
        switch (position)
        {
            case POSITION_CAMERA:
                if(emptyFragment == null)
                {
                    emptyFragment = new EmptyFragment();
                }
                return emptyFragment;

            case POSITION_SPOTLIGHT:
                if(fragmentNavigationRightSite == null)
                {
                    fragmentNavigationRightSite = FragmentNavigationRightSite.getInstance();
                }
                return fragmentNavigationRightSite;

            default:
                return null;
        }
    }

    @Override
    public int getCount()
    {
        return ViewPagerNavigationMain.PageCount;
    }

    @Override
    public int getItemPosition(@NonNull Object object)
    {
        return POSITION_NONE;
    }
}
