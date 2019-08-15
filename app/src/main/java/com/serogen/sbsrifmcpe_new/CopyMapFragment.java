package com.serogen.sbsrifmcpe_new;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class CopyMapFragment extends Fragment {
    public  final String[] EXTERNAL_PERMS = {android.Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE};
    public final int EXTERNAL_REQUEST = 138;

    CoordinatorLayout coordinatorLayout;

    public static CopyMapFragment newInstance() {
        return new CopyMapFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_copy_map,container,false);
        view.findViewById(R.id.copy_map_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (requestForPermission())
                    copyFiletoExternalStorage(R.raw.mechanisms_world);
            }
        });

        coordinatorLayout = view.findViewById(R.id.coordinator_layout);

        return view;
    }
    @TargetApi(23)
    private boolean requestForPermission() {
        boolean isPermissionOn = true;
        final int version = Build.VERSION.SDK_INT;
        if (version >= 23) {
            if (!canAccessExternalSd()) {
                isPermissionOn = false;
                requestPermissions(EXTERNAL_PERMS, EXTERNAL_REQUEST);
            }
        }
        return isPermissionOn;
    }

    private boolean canAccessExternalSd() {
        return (hasPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE));
    }

    private boolean hasPermission(String perm) {
        return (PackageManager.PERMISSION_GRANTED == ContextCompat.checkSelfPermission(getActivity(),perm));
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case EXTERNAL_REQUEST: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(getString(R.string.permission_needed));
                    builder.setCancelable(false);
                    builder.setNegativeButton(getString(R.string.cancel_answer), new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            getActivity().finish();
                        }
                    });
                    builder.setPositiveButton(getString(R.string.grant_perm_button), new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            requestForPermission();
                        }
                    });
                    AlertDialog ad = builder.create();
                    ad.show();
                    break;
                }
                return;
            }
        }
    }
    private void copyFiletoExternalStorage(int resourceId){
        final String pathSDCard = Environment.getExternalStorageDirectory() + getString(R.string.mc_map_path) + getString(R.string.mc_map_name);
        File dir = new File(Environment.getExternalStorageDirectory() + getString(R.string.mc_map_path));
        if (!dir.exists()) {
            dir.mkdirs();
        }
        try{
            InputStream in = getResources().openRawResource(resourceId);
            FileOutputStream out = null;
            out = new FileOutputStream(pathSDCard);
            byte[] buff = new byte[1024];
            int read = 0;
            try {
                while ((read = in.read(buff)) > 0) {
                    out.write(buff, 0, read);
                }
            } finally {
                in.close();
                out.close();
            }
                ((MainActivity)getActivity()).showAd();
                Toast.makeText(getActivity(),getString(R.string.copy_succesful,pathSDCard),Toast.LENGTH_LONG).show();

                PackageManager pm = getActivity().getPackageManager();
                try {
                    PackageInfo pi = pm.getPackageInfo("com.mojang.minecraftpe", 0);
                    if (compareVersions(pi.versionName, getString(R.string.supported_version))) {
                        Snackbar snackbar = Snackbar
                                .make(coordinatorLayout, getString(R.string.copy_succesful_snackbar), Snackbar.LENGTH_LONG);
                        snackbar.setAction(getString(R.string.open_btn), new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                File dataFile = new File(pathSDCard);
                                Intent intent = new Intent(Intent.ACTION_VIEW);
                                intent.setDataAndType(FileProvider.getUriForFile(getActivity(),getActivity().getPackageName() + ".com.serogen.sbsrifmcpe_new.provider",dataFile), ".mcworld");
                                intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                                startActivity(intent);
                            }
                        });
                        snackbar.setActionTextColor(Color.YELLOW);
                        snackbar.show();
                    }
                } catch (PackageManager.NameNotFoundException e) {
                    e.printStackTrace();
                }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(getActivity(),getString(R.string.copy_error,e.getMessage()),Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(getActivity(),getString(R.string.copy_error,e.getMessage()),Toast.LENGTH_LONG).show();
        }
    }

    public static final boolean compareVersions(String ver1, String ver2) {
        String[] vals1 = ver1.split("\\.");
        String[] vals2 = ver2.split("\\.");
        int i=0;

        while(i<vals1.length&&i<vals2.length&&vals1[i].equals(vals2[i])) {
            i++;
        }

        if (i<vals1.length&&i<vals2.length) {
            int diff = Integer.valueOf(vals1[i]).compareTo(Integer.valueOf(vals2[i]));
            return diff<0?false:diff==0?true:true;
        }

        return vals1.length<vals2.length?false:vals1.length==vals2.length?true:true;
    }
}
