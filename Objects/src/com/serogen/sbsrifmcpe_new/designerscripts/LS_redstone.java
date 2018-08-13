package com.serogen.sbsrifmcpe_new.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_redstone{

public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
if (((100d / 100 * width)>(100d / 100 * height))) { 
;
views.get("menu_btn").vw.setWidth((int)((50d / 100 * width)));
views.get("menu_btn").vw.setHeight((int)((15d / 100 * height)));
views.get("menu_btn").vw.setLeft((int)((25d / 100 * width)));
views.get("menu_btn").vw.setTop((int)(0d));
views.get("imageview1").vw.setWidth((int)((70d / 100 * height)));
views.get("imageview1").vw.setHeight((int)((85d / 100 * height)-(90d * scale)));
views.get("imageview1").vw.setTop((int)((15d / 100 * height)));
views.get("imageview1").vw.setLeft((int)((100d / 100 * width)-(70d / 100 * height)));
views.get("label1").vw.setLeft((int)(0d));
views.get("label1").vw.setTop((int)((15d / 100 * height)));
views.get("label1").vw.setWidth((int)((100d / 100 * width)-(70d / 100 * height)));
views.get("label1").vw.setHeight((int)((85d / 100 * height)-(90d * scale)));
;}else{ 
;
views.get("menu_btn").vw.setWidth((int)((50d / 100 * width)));
views.get("menu_btn").vw.setHeight((int)((10d / 100 * height)));
views.get("menu_btn").vw.setLeft((int)((25d / 100 * width)));
views.get("menu_btn").vw.setTop((int)(0d));
//BA.debugLineNum = 20;BA.debugLine="ImageView1.Width=50%y"[redstone/General script]
views.get("imageview1").vw.setWidth((int)((50d / 100 * height)));
//BA.debugLineNum = 21;BA.debugLine="ImageView1.Height=50%y"[redstone/General script]
views.get("imageview1").vw.setHeight((int)((50d / 100 * height)));
//BA.debugLineNum = 22;BA.debugLine="ImageView1.Top=10%y"[redstone/General script]
views.get("imageview1").vw.setTop((int)((10d / 100 * height)));
//BA.debugLineNum = 23;BA.debugLine="ImageView1.left=(100%x-50%y)/2"[redstone/General script]
views.get("imageview1").vw.setLeft((int)(((100d / 100 * width)-(50d / 100 * height))/2d));
//BA.debugLineNum = 24;BA.debugLine="Label1.Left=0"[redstone/General script]
views.get("label1").vw.setLeft((int)(0d));
//BA.debugLineNum = 25;BA.debugLine="Label1.Top=60%y"[redstone/General script]
views.get("label1").vw.setTop((int)((60d / 100 * height)));
//BA.debugLineNum = 26;BA.debugLine="Label1.Width=100%x"[redstone/General script]
views.get("label1").vw.setWidth((int)((100d / 100 * width)));
//BA.debugLineNum = 27;BA.debugLine="Label1.Height=40%y-90dip"[redstone/General script]
views.get("label1").vw.setHeight((int)((40d / 100 * height)-(90d * scale)));
//BA.debugLineNum = 28;BA.debugLine="End If"[redstone/General script]
;};

}
}