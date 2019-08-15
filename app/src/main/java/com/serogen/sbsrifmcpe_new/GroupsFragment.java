package com.serogen.sbsrifmcpe_new;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class GroupsFragment extends Fragment {

        public static GroupsFragment newInstance() {
            return new GroupsFragment();
        }

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_groups,container,false);
            ((MainActivity)getActivity()).setWindowTitle(getString(R.string.menu_categories));

            GroupsListAdapter adapter = new GroupsListAdapter(getActivity(),initList());

            final GridView gridView = view.findViewById(R.id.gridView);
            gridView.setAdapter(adapter);

            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    GroupItem item = (GroupItem) gridView.getItemAtPosition(position);

                    ((MainActivity)getActivity()).onGroupClicked(item.getId());
                }
            });

            return view;
        }

    private ArrayList<GroupItem> initList() {
        ArrayList<GroupItem> list = new ArrayList<>();

        list.add(new GroupItem(R.drawable.group_cmd_block,getString(R.string.group_command_blocks),1));
        list.add(new GroupItem(R.drawable.group_piston_doors,getString(R.string.group_piston_doors),2));
        list.add(new GroupItem(R.drawable.group_farms,getString(R.string.group_automatic_farms),3));
        list.add(new GroupItem(R.drawable.r5,getString(R.string.group_machines),4));
        list.add(new GroupItem(R.drawable.group_for_home,getString(R.string.group_for_home),5));
        list.add(new GroupItem(R.drawable.z0,getString(R.string.group_protection),6));
        list.add(new GroupItem(R.drawable.d10,getString(R.string.group_other),7));

        return list;
    }
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser && isResumed()) {
            onResume();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (!getUserVisibleHint()) {
            return;
        }
        ((MainActivity)getActivity()).showCountAd();
    }
}