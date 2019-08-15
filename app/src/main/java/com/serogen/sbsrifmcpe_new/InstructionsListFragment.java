package com.serogen.sbsrifmcpe_new;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import java.util.ArrayList;

public class InstructionsListFragment extends ListFragment {
//((MainActivity)getActivity())
    EditText searchEditText;

    public static InstructionsListFragment newInstance(int ID) {
        Bundle b = new Bundle();
        b.putInt("group_id",ID);
        InstructionsListFragment f = new InstructionsListFragment();
        f.setArguments(b);
        return f;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_instructionslist,container,false);

        searchEditText = view.findViewById(R.id.search_editText);

        Bundle bundle = getArguments();
        int ID = bundle.getInt("group_id");
        setWindowTitle(ID);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle bundle = getArguments();
        int ID = bundle.getInt("group_id");
        final InstructionListAdapter adapter = new InstructionListAdapter(getActivity(),R.layout.instruction_list_item,initList(ID));
        setListAdapter(adapter);

        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                adapter.getFilter().filter(s.toString());
            }
        });
    }
    private ArrayList<InstructionItemFromInstructionsList> initList(int id) {
        ArrayList<InstructionItemFromInstructionsList> list = new ArrayList<>();
        switch (id) {
            case 0:
                list.add(new InstructionItemFromInstructionsList(R.drawable.a10,getString(R.string.A_instruction_label),false,0));
                list.add(new InstructionItemFromInstructionsList(R.drawable.b4,getString(R.string.B_instruction_label),false,1));
                list.add(new InstructionItemFromInstructionsList(R.drawable.c5,getString(R.string.C_instruction_label),false,2));
                list.add(new InstructionItemFromInstructionsList(R.drawable.d10,getString(R.string.D_instruction_label),false,3));
                list.add(new InstructionItemFromInstructionsList(R.drawable.e11,getString(R.string.E_instruction_label),false,4));
                list.add(new InstructionItemFromInstructionsList(R.drawable.f5,getString(R.string.F_instruction_label),true,5));
                list.add(new InstructionItemFromInstructionsList(R.drawable.g13,getString(R.string.G_instruction_label),false,6));
                list.add(new InstructionItemFromInstructionsList(R.drawable.h9,getString(R.string.H_instruction_label),false,7));
                list.add(new InstructionItemFromInstructionsList(R.drawable.i18,getString(R.string.I_instruction_label),true,8));
                list.add(new InstructionItemFromInstructionsList(R.drawable.j11,getString(R.string.J_instruction_label),true,9));
                list.add(new InstructionItemFromInstructionsList(R.drawable.k8,getString(R.string.K_instruction_label),true,10));
                list.add(new InstructionItemFromInstructionsList(R.drawable.r5,getString(R.string.R_instruction_label),true,17));
                list.add(new InstructionItemFromInstructionsList(R.drawable.u3,getString(R.string.U_instruction_label),false,20));
                list.add(new InstructionItemFromInstructionsList(R.drawable.v8,getString(R.string.V_instruction_label),false,21));
                list.add(new InstructionItemFromInstructionsList(R.drawable.w8,getString(R.string.W_instruction_label),false,22));
                list.add(new InstructionItemFromInstructionsList(R.drawable.x12,getString(R.string.X_instruction_label),false,23));
                list.add(new InstructionItemFromInstructionsList(R.drawable.y2,getString(R.string.Y_instruction_label),false,24));
                list.add(new InstructionItemFromInstructionsList(R.drawable.z0,getString(R.string.Z_instruction_label),false,25));
                break;
            case 1:
                list.add(new InstructionItemFromInstructionsList(R.drawable.j11,getString(R.string.J_instruction_label),false,9));
                break;
            case 2:
                list.add(new InstructionItemFromInstructionsList(R.drawable.a10,getString(R.string.A_instruction_label),false,0));
                list.add(new InstructionItemFromInstructionsList(R.drawable.c5,getString(R.string.C_instruction_label),false,2));
                list.add(new InstructionItemFromInstructionsList(R.drawable.i18,getString(R.string.I_instruction_label),false,8));
                break;
            case 3:
                list.add(new InstructionItemFromInstructionsList(R.drawable.g13,getString(R.string.G_instruction_label),false,6));
                list.add(new InstructionItemFromInstructionsList(R.drawable.v8,getString(R.string.V_instruction_label),false,21));
                break;
            case 4:
                list.add(new InstructionItemFromInstructionsList(R.drawable.r5,getString(R.string.R_instruction_label),false,17));
                list.add(new InstructionItemFromInstructionsList(R.drawable.k8,getString(R.string.K_instruction_label),false,10));
                break;
            case 5:
                list.add(new InstructionItemFromInstructionsList(R.drawable.y2,getString(R.string.Y_instruction_label),false,24));
                list.add(new InstructionItemFromInstructionsList(R.drawable.w8,getString(R.string.W_instruction_label),false,22));
                list.add(new InstructionItemFromInstructionsList(R.drawable.h9,getString(R.string.H_instruction_label),false,7));
                list.add(new InstructionItemFromInstructionsList(R.drawable.j11,getString(R.string.J_instruction_label),false,9));
                list.add(new InstructionItemFromInstructionsList(R.drawable.e11,getString(R.string.E_instruction_label),false,4));
                break;
            case 6:
                list.add(new InstructionItemFromInstructionsList(R.drawable.f5,getString(R.string.F_instruction_label),false,5));
                list.add(new InstructionItemFromInstructionsList(R.drawable.z0,getString(R.string.Z_instruction_label),false,25));
                list.add(new InstructionItemFromInstructionsList(R.drawable.x12,getString(R.string.X_instruction_label),false,23));
                break;
            case 7:
                list.add(new InstructionItemFromInstructionsList(R.drawable.b4,getString(R.string.B_instruction_label),false,1));
                list.add(new InstructionItemFromInstructionsList(R.drawable.u3,getString(R.string.U_instruction_label),false,20));
                list.add(new InstructionItemFromInstructionsList(R.drawable.d10,getString(R.string.D_instruction_label),false,3));
                break;
        }
        return list;
    }
    private void setWindowTitle(int ID) {
        switch (ID) {
            case 0:
                ((MainActivity)getActivity()).setWindowTitle(getString(R.string.group_all));
                break;
            case 1:
                ((MainActivity)getActivity()).setWindowTitle(getString(R.string.group_command_blocks));
                break;
            case 2:
                ((MainActivity)getActivity()).setWindowTitle(getString(R.string.group_piston_doors));
                break;
            case 3:
                ((MainActivity)getActivity()).setWindowTitle(getString(R.string.group_automatic_farms));
                break;
            case 4:
                ((MainActivity)getActivity()).setWindowTitle(getString(R.string.group_machines));
                break;
            case 5:
                ((MainActivity)getActivity()).setWindowTitle(getString(R.string.group_for_home));
                break;
            case 6:
                ((MainActivity)getActivity()).setWindowTitle(getString(R.string.group_protection));
                break;
            case 7:
                ((MainActivity)getActivity()).setWindowTitle(getString(R.string.group_other));
                break;
        }
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