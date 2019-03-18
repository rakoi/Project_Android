package classeye.project.app.classeyes;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class PageAdapter extends FragmentPagerAdapter {

    public int pageCount;

    public PageAdapter(FragmentManager fm,int pageCount) {
        super(fm);
        this.pageCount=pageCount;

    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new Home();

            case 1:
                return new Chart();

            case 2:
                return new Records();

                default:
                    return new Home();

        }


           }

    @Override
    public int getCount() {
        return pageCount;
    }
}
