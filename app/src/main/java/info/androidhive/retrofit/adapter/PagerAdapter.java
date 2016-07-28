package info.androidhive.retrofit.adapter;

/**
 * Created by mgkan on 2016-07-28.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import info.androidhive.retrofit.fragment.DirectorFragment;

public class PagerAdapter extends FragmentStatePagerAdapter {
  int mNumOfTabs;

  public PagerAdapter(FragmentManager fm, int NumOfTabs) {
    super(fm);
    this.mNumOfTabs = NumOfTabs;
  }

  @Override
  public Fragment getItem(int position) {
    Bundle bundle = new Bundle();
    DirectorFragment tab1 = new DirectorFragment();
    switch (position) {
      case 0:
        bundle.putInt("directorId", 488);
        tab1.setArguments(bundle);
        return tab1;
      case 1:
        bundle.putInt("directorId", 1);
        tab1.setArguments(bundle);
        return tab1;
      case 2:
        bundle.putInt("directorId", 2710);
        tab1.setArguments(bundle);
        return tab1;
      default:
        return null;
    }
  }

  @Override
  public int getCount() {
    return mNumOfTabs;
  }
}
