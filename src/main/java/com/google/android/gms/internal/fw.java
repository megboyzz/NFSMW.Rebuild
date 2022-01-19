/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 */
package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.du;
import com.google.android.gms.internal.fx;

public final class fw
implements SafeParcelable {
    public static final fx CREATOR;
    public static final fw uA;
    public static final fw uB;
    public static final fw uC;
    public static final fw uD;
    public static final fw uE;
    public static final fw uF;
    public static final fw uG;
    public static final fw uH;
    public static final fw uI;
    public static final fw uJ;
    public static final fw uK;
    public static final fw uL;
    public static final fw uM;
    public static final fw uN;
    public static final fw uO;
    public static final fw uP;
    public static final fw uQ;
    public static final fw uR;
    public static final fw uS;
    public static final fw uT;
    public static final fw uU;
    public static final fw uV;
    public static final fw uW;
    public static final fw uX;
    public static final fw uY;
    public static final fw uZ;
    public static final fw uk;
    public static final fw ul;
    public static final fw um;
    public static final fw un;
    public static final fw uo;
    public static final fw up;
    public static final fw uq;
    public static final fw ur;
    public static final fw us;
    public static final fw ut;
    public static final fw uu;
    public static final fw uv;
    public static final fw uw;
    public static final fw ux;
    public static final fw uy;
    public static final fw uz;
    public static final fw vA;
    public static final fw vB;
    public static final fw vC;
    public static final fw vD;
    public static final fw vE;
    public static final fw vF;
    public static final fw vG;
    public static final fw vH;
    public static final fw vI;
    public static final fw vJ;
    public static final fw vK;
    public static final fw vL;
    public static final fw vM;
    public static final fw vN;
    public static final fw vO;
    public static final fw vP;
    public static final fw vQ;
    public static final fw vR;
    public static final fw vS;
    public static final fw vT;
    public static final fw vU;
    public static final fw vV;
    public static final fw vW;
    public static final fw vX;
    public static final fw vY;
    public static final fw vZ;
    public static final fw va;
    public static final fw vb;
    public static final fw vc;
    public static final fw vd;
    public static final fw ve;
    public static final fw vf;
    public static final fw vg;
    public static final fw vh;
    public static final fw vi;
    public static final fw vj;
    public static final fw vk;
    public static final fw vl;
    public static final fw vm;
    public static final fw vn;
    public static final fw vo;
    public static final fw vp;
    public static final fw vq;
    public static final fw vr;
    public static final fw vs;
    public static final fw vt;
    public static final fw vu;
    public static final fw vv;
    public static final fw vw;
    public static final fw vx;
    public static final fw vy;
    public static final fw vz;
    public static final fw wA;
    public static final fw wB;
    public static final fw wC;
    public static final fw wD;
    public static final fw wE;
    public static final fw wa;
    public static final fw wb;
    public static final fw wc;
    public static final fw wd;
    public static final fw we;
    public static final fw wf;
    public static final fw wg;
    public static final fw wh;
    public static final fw wi;
    public static final fw wj;
    public static final fw wk;
    public static final fw wl;
    public static final fw wm;
    public static final fw wn;
    public static final fw wo;
    public static final fw wp;
    public static final fw wq;
    public static final fw wr;
    public static final fw ws;
    public static final fw wt;
    public static final fw wu;
    public static final fw wv;
    public static final fw ww;
    public static final fw wx;
    public static final fw wy;
    public static final fw wz;
    final int kZ;
    final String wF;

    static {
        uk = fw.ab("accounting");
        ul = fw.ab("airport");
        um = fw.ab("amusement_park");
        un = fw.ab("aquarium");
        uo = fw.ab("art_gallery");
        up = fw.ab("atm");
        uq = fw.ab("bakery");
        ur = fw.ab("bank");
        us = fw.ab("bar");
        ut = fw.ab("beauty_salon");
        uu = fw.ab("bicycle_store");
        uv = fw.ab("book_store");
        uw = fw.ab("bowling_alley");
        ux = fw.ab("bus_station");
        uy = fw.ab("cafe");
        uz = fw.ab("campground");
        uA = fw.ab("car_dealer");
        uB = fw.ab("car_rental");
        uC = fw.ab("car_repair");
        uD = fw.ab("car_wash");
        uE = fw.ab("casino");
        uF = fw.ab("cemetary");
        uG = fw.ab("church");
        uH = fw.ab("city_hall");
        uI = fw.ab("clothing_store");
        uJ = fw.ab("convenience_store");
        uK = fw.ab("courthouse");
        uL = fw.ab("dentist");
        uM = fw.ab("department_store");
        uN = fw.ab("doctor");
        uO = fw.ab("electrician");
        uP = fw.ab("electronics_store");
        uQ = fw.ab("embassy");
        uR = fw.ab("establishment");
        uS = fw.ab("finance");
        uT = fw.ab("fire_station");
        uU = fw.ab("florist");
        uV = fw.ab("food");
        uW = fw.ab("funeral_home");
        uX = fw.ab("furniture_store");
        uY = fw.ab("gas_station");
        uZ = fw.ab("general_contractor");
        va = fw.ab("grocery_or_supermarket");
        vb = fw.ab("gym");
        vc = fw.ab("hair_care");
        vd = fw.ab("hardware_store");
        ve = fw.ab("health");
        vf = fw.ab("hindu_temple");
        vg = fw.ab("home_goods_store");
        vh = fw.ab("hospital");
        vi = fw.ab("insurance_agency");
        vj = fw.ab("jewelry_store");
        vk = fw.ab("laundry");
        vl = fw.ab("lawyer");
        vm = fw.ab("library");
        vn = fw.ab("liquor_store");
        vo = fw.ab("local_government_office");
        vp = fw.ab("locksmith");
        vq = fw.ab("lodging");
        vr = fw.ab("meal_delivery");
        vs = fw.ab("meal_takeaway");
        vt = fw.ab("mosque");
        vu = fw.ab("movie_rental");
        vv = fw.ab("movie_theater");
        vw = fw.ab("moving_company");
        vx = fw.ab("museum");
        vy = fw.ab("night_club");
        vz = fw.ab("painter");
        vA = fw.ab("park");
        vB = fw.ab("parking");
        vC = fw.ab("pet_store");
        vD = fw.ab("pharmacy");
        vE = fw.ab("physiotherapist");
        vF = fw.ab("place_of_worship");
        vG = fw.ab("plumber");
        vH = fw.ab("police");
        vI = fw.ab("post_office");
        vJ = fw.ab("real_estate_agency");
        vK = fw.ab("restaurant");
        vL = fw.ab("roofing_contractor");
        vM = fw.ab("rv_park");
        vN = fw.ab("school");
        vO = fw.ab("shoe_store");
        vP = fw.ab("shopping_mall");
        vQ = fw.ab("spa");
        vR = fw.ab("stadium");
        vS = fw.ab("storage");
        vT = fw.ab("store");
        vU = fw.ab("subway_station");
        vV = fw.ab("synagogue");
        vW = fw.ab("taxi_stand");
        vX = fw.ab("train_station");
        vY = fw.ab("travel_agency");
        vZ = fw.ab("university");
        wa = fw.ab("veterinary_care");
        wb = fw.ab("zoo");
        wc = fw.ab("administrative_area_level_1");
        wd = fw.ab("administrative_area_level_2");
        we = fw.ab("administrative_area_level_3");
        wf = fw.ab("colloquial_area");
        wg = fw.ab("country");
        wh = fw.ab("floor");
        wi = fw.ab("geocode");
        wj = fw.ab("intersection");
        wk = fw.ab("locality");
        wl = fw.ab("natural_feature");
        wm = fw.ab("neighborhood");
        wn = fw.ab("political");
        wo = fw.ab("point_of_interest");
        wp = fw.ab("post_box");
        wq = fw.ab("postal_code");
        wr = fw.ab("postal_code_prefix");
        ws = fw.ab("postal_town");
        wt = fw.ab("premise");
        wu = fw.ab("room");
        wv = fw.ab("route");
        ww = fw.ab("street_address");
        wx = fw.ab("sublocality");
        wy = fw.ab("sublocality_level_1");
        wz = fw.ab("sublocality_level_2");
        wA = fw.ab("sublocality_level_3");
        wB = fw.ab("sublocality_level_4");
        wC = fw.ab("sublocality_level_5");
        wD = fw.ab("subpremise");
        wE = fw.ab("transit_station");
        CREATOR = new fx();
    }

    fw(int n2, String string2) {
        du.I(string2);
        this.kZ = n2;
        this.wF = string2;
    }

    public static fw ab(String string2) {
        return new fw(0, string2);
    }

    public int describeContents() {
        fx fx2 = CREATOR;
        return 0;
    }

    public boolean equals(Object object) {
        if (!(object instanceof fw)) return false;
        if (!this.wF.equals(((fw)object).wF)) return false;
        return true;
    }

    public int hashCode() {
        return this.wF.hashCode();
    }

    public String toString() {
        return this.wF;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        fx fx2 = CREATOR;
        fx.a(this, parcel, n2);
    }
}

