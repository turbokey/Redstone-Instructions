package com.serogen.sbsrifmcpe_new.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_imagescrollview{

public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
//BA.debugLineNum = 2;BA.debugLine="If 100%x > 100%y Then"[imagescrollview/General script]
if (((100d / 100 * width)>(100d / 100 * height))) { 
;
//BA.debugLineNum = 3;BA.debugLine="ImageView1.Width=100%y"[imagescrollview/General script]
views.get("imageview1").vw.setWidth((int)((100d / 100 * height)));
//BA.debugLineNum = 4;BA.debugLine="ImageView1.Height=100%y"[imagescrollview/General script]
views.get("imageview1").vw.setHeight((int)((100d / 100 * height)));
//BA.debugLineNum = 5;BA.debugLine="ImageView1.Top=0"[imagescrollview/General script]
views.get("imageview1").vw.setTop((int)(0d));
//BA.debugLineNum = 6;BA.debugLine="ImageView1.left=100%x-100%y"[imagescrollview/General script]
views.get("imageview1").vw.setLeft((int)((100d / 100 * width)-(100d / 100 * height)));
//BA.debugLineNum = 7;BA.debugLine="Label1.Left=0"[imagescrollview/General script]
views.get("label1").vw.setLeft((int)(0d));
//BA.debugLineNum = 8;BA.debugLine="Label1.Top=10%y"[imagescrollview/General script]
views.get("label1").vw.setTop((int)((10d / 100 * height)));
//BA.debugLineNum = 9;BA.debugLine="Label1.Width=100%x-100%y"[imagescrollview/General script]
views.get("label1").vw.setWidth((int)((100d / 100 * width)-(100d / 100 * height)));
//BA.debugLineNum = 10;BA.debugLine="Label1.Height=90%y"[imagescrollview/General script]
views.get("label1").vw.setHeight((int)((90d / 100 * height)));
//BA.debugLineNum = 11;BA.debugLine="Else"[imagescrollview/General script]
;}else{ 
;
//BA.debugLineNum = 12;BA.debugLine="ImageView1.Width=50%y"[imagescrollview/General script]
views.get("imageview1").vw.setWidth((int)((50d / 100 * height)));
//BA.debugLineNum = 13;BA.debugLine="ImageView1.Height=50%y"[imagescrollview/General script]
views.get("imageview1").vw.setHeight((int)((50d / 100 * height)));
//BA.debugLineNum = 14;BA.debugLine="ImageView1.Top=0"[imagescrollview/General script]
views.get("imageview1").vw.setTop((int)(0d));
//BA.debugLineNum = 15;BA.debugLine="ImageView1.left=(100%x-50%y)/2"[imagescrollview/General script]
views.get("imageview1").vw.setLeft((int)(((100d / 100 * width)-(50d / 100 * height))/2d));
//BA.debugLineNum = 16;BA.debugLine="Label1.Left=0"[imagescrollview/General script]
views.get("label1").vw.setLeft((int)(0d));
//BA.debugLineNum = 17;BA.debugLine="Label1.Top=50%y"[imagescrollview/General script]
views.get("label1").vw.setTop((int)((50d / 100 * height)));
//BA.debugLineNum = 18;BA.debugLine="Label1.Width=100%x"[imagescrollview/General script]
views.get("label1").vw.setWidth((int)((100d / 100 * width)));
//BA.debugLineNum = 19;BA.debugLine="Label1.Height=50%y"[imagescrollview/General script]
views.get("label1").vw.setHeight((int)((50d / 100 * height)));
//BA.debugLineNum = 20;BA.debugLine="End If"[imagescrollview/General script]
;};

}
}