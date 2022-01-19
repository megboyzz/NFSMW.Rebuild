/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 */
package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.eb;
import com.google.android.gms.internal.ee;
import com.google.android.gms.internal.hb;
import com.google.android.gms.internal.hc;
import com.google.android.gms.internal.hd;
import com.google.android.gms.internal.he;
import com.google.android.gms.internal.hf;
import com.google.android.gms.internal.hg;
import com.google.android.gms.internal.hh;
import com.google.android.gms.internal.hi;
import com.google.android.gms.internal.hj;
import com.google.android.gms.internal.hk;
import com.google.android.gms.plus.model.people.Person;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class ha
extends ee
implements SafeParcelable,
Person {
    public static final hb CREATOR = new hb();
    private static final HashMap<String, ee.a<?, ?>> zP = new HashMap();
    private String AP;
    private a AQ;
    private String AR;
    private String AS;
    private int AT;
    private b AU;
    private String AV;
    private c AW;
    private boolean AX;
    private String AY;
    private d AZ;
    private String Ba;
    private int Bb;
    private List<f> Bc;
    private List<g> Bd;
    private int Be;
    private int Bf;
    private String Bg;
    private List<h> Bh;
    private boolean Bi;
    private int eL;
    private String iD;
    private final int kZ;
    private String pW;
    private String wJ;
    private final Set<Integer> zQ;

    static {
        zP.put("aboutMe", ee.a.f("aboutMe", 2));
        zP.put("ageRange", ee.a.a("ageRange", 3, a.class));
        zP.put("birthday", ee.a.f("birthday", 4));
        zP.put("braggingRights", ee.a.f("braggingRights", 5));
        zP.put("circledByCount", ee.a.c("circledByCount", 6));
        zP.put("cover", ee.a.a("cover", 7, b.class));
        zP.put("currentLocation", ee.a.f("currentLocation", 8));
        zP.put("displayName", ee.a.f("displayName", 9));
        zP.put("gender", ee.a.a("gender", 12, new eb().b("male", 0).b("female", 1).b("other", 2), false));
        zP.put("id", ee.a.f("id", 14));
        zP.put("image", ee.a.a("image", 15, c.class));
        zP.put("isPlusUser", ee.a.e("isPlusUser", 16));
        zP.put("language", ee.a.f("language", 18));
        zP.put("name", ee.a.a("name", 19, d.class));
        zP.put("nickname", ee.a.f("nickname", 20));
        zP.put("objectType", ee.a.a("objectType", 21, new eb().b("person", 0).b("page", 1), false));
        zP.put("organizations", ee.a.b("organizations", 22, f.class));
        zP.put("placesLived", ee.a.b("placesLived", 23, g.class));
        zP.put("plusOneCount", ee.a.c("plusOneCount", 24));
        zP.put("relationshipStatus", ee.a.a("relationshipStatus", 25, new eb().b("single", 0).b("in_a_relationship", 1).b("engaged", 2).b("married", 3).b("its_complicated", 4).b("open_relationship", 5).b("widowed", 6).b("in_domestic_partnership", 7).b("in_civil_union", 8), false));
        zP.put("tagline", ee.a.f("tagline", 26));
        zP.put("url", ee.a.f("url", 27));
        zP.put("urls", ee.a.b("urls", 28, h.class));
        zP.put("verified", ee.a.e("verified", 29));
    }

    public ha() {
        this.kZ = 2;
        this.zQ = new HashSet<Integer>();
    }

    public ha(String string2, String string3, c c2, int n2, String string4) {
        this.kZ = 2;
        this.zQ = new HashSet<Integer>();
        this.pW = string2;
        this.zQ.add(9);
        this.wJ = string3;
        this.zQ.add(14);
        this.AW = c2;
        this.zQ.add(15);
        this.Bb = n2;
        this.zQ.add(21);
        this.iD = string4;
        this.zQ.add(27);
    }

    ha(Set<Integer> set, int n2, String string2, a a2, String string3, String string4, int n3, b b2, String string5, String string6, int n4, String string7, c c2, boolean bl2, String string8, d d2, String string9, int n5, List<f> list, List<g> list2, int n6, int n7, String string10, String string11, List<h> list3, boolean bl3) {
        this.zQ = set;
        this.kZ = n2;
        this.AP = string2;
        this.AQ = a2;
        this.AR = string3;
        this.AS = string4;
        this.AT = n3;
        this.AU = b2;
        this.AV = string5;
        this.pW = string6;
        this.eL = n4;
        this.wJ = string7;
        this.AW = c2;
        this.AX = bl2;
        this.AY = string8;
        this.AZ = d2;
        this.Ba = string9;
        this.Bb = n5;
        this.Bc = list;
        this.Bd = list2;
        this.Be = n6;
        this.Bf = n7;
        this.Bg = string10;
        this.iD = string11;
        this.Bh = list3;
        this.Bi = bl3;
    }

    public static ha g(byte[] object) {
        Parcel parcel = Parcel.obtain();
        parcel.unmarshall(object, 0, ((byte[])object).length);
        parcel.setDataPosition(0);
        object = CREATOR.al(parcel);
        parcel.recycle();
        return object;
    }

    @Override
    protected Object J(String string2) {
        return null;
    }

    @Override
    protected boolean K(String string2) {
        return false;
    }

    @Override
    protected boolean a(ee.a a2) {
        return this.zQ.contains(a2.bX());
    }

    @Override
    protected Object b(ee.a a2) {
        switch (a2.bX()) {
            default: {
                throw new IllegalStateException("Unknown safe parcelable id=" + a2.bX());
            }
            case 2: {
                return this.AP;
            }
            case 3: {
                return this.AQ;
            }
            case 4: {
                return this.AR;
            }
            case 5: {
                return this.AS;
            }
            case 6: {
                return this.AT;
            }
            case 7: {
                return this.AU;
            }
            case 8: {
                return this.AV;
            }
            case 9: {
                return this.pW;
            }
            case 12: {
                return this.eL;
            }
            case 14: {
                return this.wJ;
            }
            case 15: {
                return this.AW;
            }
            case 16: {
                return this.AX;
            }
            case 18: {
                return this.AY;
            }
            case 19: {
                return this.AZ;
            }
            case 20: {
                return this.Ba;
            }
            case 21: {
                return this.Bb;
            }
            case 22: {
                return this.Bc;
            }
            case 23: {
                return this.Bd;
            }
            case 24: {
                return this.Be;
            }
            case 25: {
                return this.Bf;
            }
            case 26: {
                return this.Bg;
            }
            case 27: {
                return this.iD;
            }
            case 28: {
                return this.Bh;
            }
            case 29: 
        }
        return this.Bi;
    }

    @Override
    public HashMap<String, ee.a<?, ?>> bQ() {
        return zP;
    }

    public int describeContents() {
        hb hb2 = CREATOR;
        return 0;
    }

    Set<Integer> eF() {
        return this.zQ;
    }

    public boolean equals(Object object) {
        if (!(object instanceof ha)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        object = (ha)object;
        Iterator<ee.a<?, ?>> iterator = zP.values().iterator();
        while (iterator.hasNext()) {
            ee.a<?, ?> a2 = iterator.next();
            if (this.a(a2)) {
                if (!((ha)object).a(a2)) return false;
                if (this.b(a2).equals(((ha)object).b(a2))) continue;
                return false;
            }
            if (((ha)object).a(a2)) return false;
        }
        return true;
    }

    a fa() {
        return this.AQ;
    }

    b fb() {
        return this.AU;
    }

    c fc() {
        return this.AW;
    }

    d fd() {
        return this.AZ;
    }

    List<f> fe() {
        return this.Bc;
    }

    List<g> ff() {
        return this.Bd;
    }

    List<h> fg() {
        return this.Bh;
    }

    public ha fh() {
        return this;
    }

    @Override
    public /* synthetic */ Object freeze() {
        return this.fh();
    }

    @Override
    public String getAboutMe() {
        return this.AP;
    }

    @Override
    public Person.AgeRange getAgeRange() {
        return this.AQ;
    }

    @Override
    public String getBirthday() {
        return this.AR;
    }

    @Override
    public String getBraggingRights() {
        return this.AS;
    }

    @Override
    public int getCircledByCount() {
        return this.AT;
    }

    @Override
    public Person.Cover getCover() {
        return this.AU;
    }

    @Override
    public String getCurrentLocation() {
        return this.AV;
    }

    @Override
    public String getDisplayName() {
        return this.pW;
    }

    @Override
    public int getGender() {
        return this.eL;
    }

    @Override
    public String getId() {
        return this.wJ;
    }

    @Override
    public Person.Image getImage() {
        return this.AW;
    }

    @Override
    public String getLanguage() {
        return this.AY;
    }

    @Override
    public Person.Name getName() {
        return this.AZ;
    }

    @Override
    public String getNickname() {
        return this.Ba;
    }

    @Override
    public int getObjectType() {
        return this.Bb;
    }

    @Override
    public List<Person.Organizations> getOrganizations() {
        return (ArrayList)this.Bc;
    }

    @Override
    public List<Person.PlacesLived> getPlacesLived() {
        return (ArrayList)this.Bd;
    }

    @Override
    public int getPlusOneCount() {
        return this.Be;
    }

    @Override
    public int getRelationshipStatus() {
        return this.Bf;
    }

    @Override
    public String getTagline() {
        return this.Bg;
    }

    @Override
    public String getUrl() {
        return this.iD;
    }

    @Override
    public List<Person.Urls> getUrls() {
        return (ArrayList)this.Bh;
    }

    int getVersionCode() {
        return this.kZ;
    }

    @Override
    public boolean hasAboutMe() {
        return this.zQ.contains(2);
    }

    @Override
    public boolean hasAgeRange() {
        return this.zQ.contains(3);
    }

    @Override
    public boolean hasBirthday() {
        return this.zQ.contains(4);
    }

    @Override
    public boolean hasBraggingRights() {
        return this.zQ.contains(5);
    }

    @Override
    public boolean hasCircledByCount() {
        return this.zQ.contains(6);
    }

    @Override
    public boolean hasCover() {
        return this.zQ.contains(7);
    }

    @Override
    public boolean hasCurrentLocation() {
        return this.zQ.contains(8);
    }

    @Override
    public boolean hasDisplayName() {
        return this.zQ.contains(9);
    }

    @Override
    public boolean hasGender() {
        return this.zQ.contains(12);
    }

    @Override
    public boolean hasId() {
        return this.zQ.contains(14);
    }

    @Override
    public boolean hasImage() {
        return this.zQ.contains(15);
    }

    @Override
    public boolean hasIsPlusUser() {
        return this.zQ.contains(16);
    }

    @Override
    public boolean hasLanguage() {
        return this.zQ.contains(18);
    }

    @Override
    public boolean hasName() {
        return this.zQ.contains(19);
    }

    @Override
    public boolean hasNickname() {
        return this.zQ.contains(20);
    }

    @Override
    public boolean hasObjectType() {
        return this.zQ.contains(21);
    }

    @Override
    public boolean hasOrganizations() {
        return this.zQ.contains(22);
    }

    @Override
    public boolean hasPlacesLived() {
        return this.zQ.contains(23);
    }

    @Override
    public boolean hasPlusOneCount() {
        return this.zQ.contains(24);
    }

    @Override
    public boolean hasRelationshipStatus() {
        return this.zQ.contains(25);
    }

    @Override
    public boolean hasTagline() {
        return this.zQ.contains(26);
    }

    @Override
    public boolean hasUrl() {
        return this.zQ.contains(27);
    }

    @Override
    public boolean hasUrls() {
        return this.zQ.contains(28);
    }

    @Override
    public boolean hasVerified() {
        return this.zQ.contains(29);
    }

    public int hashCode() {
        Iterator<ee.a<?, ?>> iterator = zP.values().iterator();
        int n2 = 0;
        while (iterator.hasNext()) {
            ee.a<?, ?> a2 = iterator.next();
            if (!this.a(a2)) continue;
            int n3 = a2.bX();
            n2 = this.b(a2).hashCode() + (n2 + n3);
        }
        return n2;
    }

    @Override
    public boolean isDataValid() {
        return true;
    }

    @Override
    public boolean isPlusUser() {
        return this.AX;
    }

    @Override
    public boolean isVerified() {
        return this.Bi;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        hb hb2 = CREATOR;
        hb.a(this, parcel, n2);
    }

    public static final class a
    extends ee
    implements SafeParcelable,
    Person.AgeRange {
        public static final hc CREATOR = new hc();
        private static final HashMap<String, ee.a<?, ?>> zP = new HashMap();
        private int Bj;
        private int Bk;
        private final int kZ;
        private final Set<Integer> zQ;

        static {
            zP.put("max", ee.a.c("max", 2));
            zP.put("min", ee.a.c("min", 3));
        }

        public a() {
            this.kZ = 1;
            this.zQ = new HashSet<Integer>();
        }

        a(Set<Integer> set, int n2, int n3, int n4) {
            this.zQ = set;
            this.kZ = n2;
            this.Bj = n3;
            this.Bk = n4;
        }

        @Override
        protected Object J(String string2) {
            return null;
        }

        @Override
        protected boolean K(String string2) {
            return false;
        }

        @Override
        protected boolean a(ee.a a2) {
            return this.zQ.contains(a2.bX());
        }

        @Override
        protected Object b(ee.a a2) {
            switch (a2.bX()) {
                default: {
                    throw new IllegalStateException("Unknown safe parcelable id=" + a2.bX());
                }
                case 2: {
                    return this.Bj;
                }
                case 3: 
            }
            return this.Bk;
        }

        @Override
        public HashMap<String, ee.a<?, ?>> bQ() {
            return zP;
        }

        public int describeContents() {
            hc hc2 = CREATOR;
            return 0;
        }

        Set<Integer> eF() {
            return this.zQ;
        }

        public boolean equals(Object object) {
            if (!(object instanceof a)) {
                return false;
            }
            if (this == object) {
                return true;
            }
            object = (a)object;
            Iterator<ee.a<?, ?>> iterator = zP.values().iterator();
            while (iterator.hasNext()) {
                ee.a<?, ?> a2 = iterator.next();
                if (this.a(a2)) {
                    if (!((a)object).a(a2)) return false;
                    if (this.b(a2).equals(((a)object).b(a2))) continue;
                    return false;
                }
                if (((a)object).a(a2)) return false;
            }
            return true;
        }

        public a fi() {
            return this;
        }

        @Override
        public /* synthetic */ Object freeze() {
            return this.fi();
        }

        @Override
        public int getMax() {
            return this.Bj;
        }

        @Override
        public int getMin() {
            return this.Bk;
        }

        int getVersionCode() {
            return this.kZ;
        }

        @Override
        public boolean hasMax() {
            return this.zQ.contains(2);
        }

        @Override
        public boolean hasMin() {
            return this.zQ.contains(3);
        }

        public int hashCode() {
            Iterator<ee.a<?, ?>> iterator = zP.values().iterator();
            int n2 = 0;
            while (iterator.hasNext()) {
                ee.a<?, ?> a2 = iterator.next();
                if (!this.a(a2)) continue;
                int n3 = a2.bX();
                n2 = this.b(a2).hashCode() + (n2 + n3);
            }
            return n2;
        }

        @Override
        public boolean isDataValid() {
            return true;
        }

        public void writeToParcel(Parcel parcel, int n2) {
            hc hc2 = CREATOR;
            hc.a(this, parcel, n2);
        }
    }

    public static final class com.google.android.gms.internal.ha$b
    extends ee
    implements SafeParcelable,
    Person.Cover {
        public static final hd CREATOR = new hd();
        private static final HashMap<String, ee.a<?, ?>> zP = new HashMap();
        private a Bl;
        private b Bm;
        private int Bn;
        private final int kZ;
        private final Set<Integer> zQ;

        static {
            zP.put("coverInfo", ee.a.a("coverInfo", 2, a.class));
            zP.put("coverPhoto", ee.a.a("coverPhoto", 3, b.class));
            zP.put("layout", ee.a.a("layout", 4, new eb().b("banner", 0), false));
        }

        public com.google.android.gms.internal.ha$b() {
            this.kZ = 1;
            this.zQ = new HashSet<Integer>();
        }

        com.google.android.gms.internal.ha$b(Set<Integer> set, int n2, a a2, b b2, int n3) {
            this.zQ = set;
            this.kZ = n2;
            this.Bl = a2;
            this.Bm = b2;
            this.Bn = n3;
        }

        @Override
        protected Object J(String string2) {
            return null;
        }

        @Override
        protected boolean K(String string2) {
            return false;
        }

        @Override
        protected boolean a(ee.a a2) {
            return this.zQ.contains(a2.bX());
        }

        @Override
        protected Object b(ee.a a2) {
            switch (a2.bX()) {
                default: {
                    throw new IllegalStateException("Unknown safe parcelable id=" + a2.bX());
                }
                case 2: {
                    return this.Bl;
                }
                case 3: {
                    return this.Bm;
                }
                case 4: 
            }
            return this.Bn;
        }

        @Override
        public HashMap<String, ee.a<?, ?>> bQ() {
            return zP;
        }

        public int describeContents() {
            hd hd2 = CREATOR;
            return 0;
        }

        Set<Integer> eF() {
            return this.zQ;
        }

        public boolean equals(Object object) {
            if (!(object instanceof com.google.android.gms.internal.ha$b)) {
                return false;
            }
            if (this == object) {
                return true;
            }
            object = (com.google.android.gms.internal.ha$b)object;
            Iterator<ee.a<?, ?>> iterator = zP.values().iterator();
            while (iterator.hasNext()) {
                ee.a<?, ?> a2 = iterator.next();
                if (this.a(a2)) {
                    if (!((com.google.android.gms.internal.ha$b)object).a(a2)) return false;
                    if (this.b(a2).equals(((com.google.android.gms.internal.ha$b)object).b(a2))) continue;
                    return false;
                }
                if (((com.google.android.gms.internal.ha$b)object).a(a2)) return false;
            }
            return true;
        }

        a fj() {
            return this.Bl;
        }

        b fk() {
            return this.Bm;
        }

        public com.google.android.gms.internal.ha$b fl() {
            return this;
        }

        @Override
        public /* synthetic */ Object freeze() {
            return this.fl();
        }

        @Override
        public Person.Cover.CoverInfo getCoverInfo() {
            return this.Bl;
        }

        @Override
        public Person.Cover.CoverPhoto getCoverPhoto() {
            return this.Bm;
        }

        @Override
        public int getLayout() {
            return this.Bn;
        }

        int getVersionCode() {
            return this.kZ;
        }

        @Override
        public boolean hasCoverInfo() {
            return this.zQ.contains(2);
        }

        @Override
        public boolean hasCoverPhoto() {
            return this.zQ.contains(3);
        }

        @Override
        public boolean hasLayout() {
            return this.zQ.contains(4);
        }

        public int hashCode() {
            Iterator<ee.a<?, ?>> iterator = zP.values().iterator();
            int n2 = 0;
            while (iterator.hasNext()) {
                ee.a<?, ?> a2 = iterator.next();
                if (!this.a(a2)) continue;
                int n3 = a2.bX();
                n2 = this.b(a2).hashCode() + (n2 + n3);
            }
            return n2;
        }

        @Override
        public boolean isDataValid() {
            return true;
        }

        public void writeToParcel(Parcel parcel, int n2) {
            hd hd2 = CREATOR;
            hd.a(this, parcel, n2);
        }

        public static final class a
        extends ee
        implements SafeParcelable,
        Person.Cover.CoverInfo {
            public static final he CREATOR = new he();
            private static final HashMap<String, ee.a<?, ?>> zP = new HashMap();
            private int Bo;
            private int Bp;
            private final int kZ;
            private final Set<Integer> zQ;

            static {
                zP.put("leftImageOffset", ee.a.c("leftImageOffset", 2));
                zP.put("topImageOffset", ee.a.c("topImageOffset", 3));
            }

            public a() {
                this.kZ = 1;
                this.zQ = new HashSet<Integer>();
            }

            a(Set<Integer> set, int n2, int n3, int n4) {
                this.zQ = set;
                this.kZ = n2;
                this.Bo = n3;
                this.Bp = n4;
            }

            @Override
            protected Object J(String string2) {
                return null;
            }

            @Override
            protected boolean K(String string2) {
                return false;
            }

            @Override
            protected boolean a(ee.a a2) {
                return this.zQ.contains(a2.bX());
            }

            @Override
            protected Object b(ee.a a2) {
                switch (a2.bX()) {
                    default: {
                        throw new IllegalStateException("Unknown safe parcelable id=" + a2.bX());
                    }
                    case 2: {
                        return this.Bo;
                    }
                    case 3: 
                }
                return this.Bp;
            }

            @Override
            public HashMap<String, ee.a<?, ?>> bQ() {
                return zP;
            }

            public int describeContents() {
                he he2 = CREATOR;
                return 0;
            }

            Set<Integer> eF() {
                return this.zQ;
            }

            public boolean equals(Object object) {
                if (!(object instanceof a)) {
                    return false;
                }
                if (this == object) {
                    return true;
                }
                object = (a)object;
                Iterator<ee.a<?, ?>> iterator = zP.values().iterator();
                while (iterator.hasNext()) {
                    ee.a<?, ?> a2 = iterator.next();
                    if (this.a(a2)) {
                        if (!((a)object).a(a2)) return false;
                        if (this.b(a2).equals(((a)object).b(a2))) continue;
                        return false;
                    }
                    if (((a)object).a(a2)) return false;
                }
                return true;
            }

            public a fm() {
                return this;
            }

            @Override
            public /* synthetic */ Object freeze() {
                return this.fm();
            }

            @Override
            public int getLeftImageOffset() {
                return this.Bo;
            }

            @Override
            public int getTopImageOffset() {
                return this.Bp;
            }

            int getVersionCode() {
                return this.kZ;
            }

            @Override
            public boolean hasLeftImageOffset() {
                return this.zQ.contains(2);
            }

            @Override
            public boolean hasTopImageOffset() {
                return this.zQ.contains(3);
            }

            public int hashCode() {
                Iterator<ee.a<?, ?>> iterator = zP.values().iterator();
                int n2 = 0;
                while (iterator.hasNext()) {
                    ee.a<?, ?> a2 = iterator.next();
                    if (!this.a(a2)) continue;
                    int n3 = a2.bX();
                    n2 = this.b(a2).hashCode() + (n2 + n3);
                }
                return n2;
            }

            @Override
            public boolean isDataValid() {
                return true;
            }

            public void writeToParcel(Parcel parcel, int n2) {
                he he2 = CREATOR;
                he.a(this, parcel, n2);
            }
        }

        public static final class b
        extends ee
        implements SafeParcelable,
        Person.Cover.CoverPhoto {
            public static final hf CREATOR = new hf();
            private static final HashMap<String, ee.a<?, ?>> zP = new HashMap();
            private String iD;
            private final int kZ;
            private int v;
            private int w;
            private final Set<Integer> zQ;

            static {
                zP.put("height", ee.a.c("height", 2));
                zP.put("url", ee.a.f("url", 3));
                zP.put("width", ee.a.c("width", 4));
            }

            public b() {
                this.kZ = 1;
                this.zQ = new HashSet<Integer>();
            }

            b(Set<Integer> set, int n2, int n3, String string2, int n4) {
                this.zQ = set;
                this.kZ = n2;
                this.v = n3;
                this.iD = string2;
                this.w = n4;
            }

            @Override
            protected Object J(String string2) {
                return null;
            }

            @Override
            protected boolean K(String string2) {
                return false;
            }

            @Override
            protected boolean a(ee.a a2) {
                return this.zQ.contains(a2.bX());
            }

            @Override
            protected Object b(ee.a a2) {
                switch (a2.bX()) {
                    default: {
                        throw new IllegalStateException("Unknown safe parcelable id=" + a2.bX());
                    }
                    case 2: {
                        return this.v;
                    }
                    case 3: {
                        return this.iD;
                    }
                    case 4: 
                }
                return this.w;
            }

            @Override
            public HashMap<String, ee.a<?, ?>> bQ() {
                return zP;
            }

            public int describeContents() {
                hf hf2 = CREATOR;
                return 0;
            }

            Set<Integer> eF() {
                return this.zQ;
            }

            public boolean equals(Object object) {
                if (!(object instanceof b)) {
                    return false;
                }
                if (this == object) {
                    return true;
                }
                object = (b)object;
                Iterator<ee.a<?, ?>> iterator = zP.values().iterator();
                while (iterator.hasNext()) {
                    ee.a<?, ?> a2 = iterator.next();
                    if (this.a(a2)) {
                        if (!((b)object).a(a2)) return false;
                        if (this.b(a2).equals(((b)object).b(a2))) continue;
                        return false;
                    }
                    if (((b)object).a(a2)) return false;
                }
                return true;
            }

            public b fn() {
                return this;
            }

            @Override
            public /* synthetic */ Object freeze() {
                return this.fn();
            }

            @Override
            public int getHeight() {
                return this.v;
            }

            @Override
            public String getUrl() {
                return this.iD;
            }

            int getVersionCode() {
                return this.kZ;
            }

            @Override
            public int getWidth() {
                return this.w;
            }

            @Override
            public boolean hasHeight() {
                return this.zQ.contains(2);
            }

            @Override
            public boolean hasUrl() {
                return this.zQ.contains(3);
            }

            @Override
            public boolean hasWidth() {
                return this.zQ.contains(4);
            }

            public int hashCode() {
                Iterator<ee.a<?, ?>> iterator = zP.values().iterator();
                int n2 = 0;
                while (iterator.hasNext()) {
                    ee.a<?, ?> a2 = iterator.next();
                    if (!this.a(a2)) continue;
                    int n3 = a2.bX();
                    n2 = this.b(a2).hashCode() + (n2 + n3);
                }
                return n2;
            }

            @Override
            public boolean isDataValid() {
                return true;
            }

            public void writeToParcel(Parcel parcel, int n2) {
                hf hf2 = CREATOR;
                hf.a(this, parcel, n2);
            }
        }
    }

    public static final class c
    extends ee
    implements SafeParcelable,
    Person.Image {
        public static final hg CREATOR = new hg();
        private static final HashMap<String, ee.a<?, ?>> zP = new HashMap();
        private String iD;
        private final int kZ;
        private final Set<Integer> zQ;

        static {
            zP.put("url", ee.a.f("url", 2));
        }

        public c() {
            this.kZ = 1;
            this.zQ = new HashSet<Integer>();
        }

        public c(String string2) {
            this.zQ = new HashSet<Integer>();
            this.kZ = 1;
            this.iD = string2;
            this.zQ.add(2);
        }

        c(Set<Integer> set, int n2, String string2) {
            this.zQ = set;
            this.kZ = n2;
            this.iD = string2;
        }

        @Override
        protected Object J(String string2) {
            return null;
        }

        @Override
        protected boolean K(String string2) {
            return false;
        }

        @Override
        protected boolean a(ee.a a2) {
            return this.zQ.contains(a2.bX());
        }

        @Override
        protected Object b(ee.a a2) {
            switch (a2.bX()) {
                default: {
                    throw new IllegalStateException("Unknown safe parcelable id=" + a2.bX());
                }
                case 2: 
            }
            return this.iD;
        }

        @Override
        public HashMap<String, ee.a<?, ?>> bQ() {
            return zP;
        }

        public int describeContents() {
            hg hg2 = CREATOR;
            return 0;
        }

        Set<Integer> eF() {
            return this.zQ;
        }

        public boolean equals(Object object) {
            if (!(object instanceof c)) {
                return false;
            }
            if (this == object) {
                return true;
            }
            object = (c)object;
            Iterator<ee.a<?, ?>> iterator = zP.values().iterator();
            while (iterator.hasNext()) {
                ee.a<?, ?> a2 = iterator.next();
                if (this.a(a2)) {
                    if (!((c)object).a(a2)) return false;
                    if (this.b(a2).equals(((c)object).b(a2))) continue;
                    return false;
                }
                if (((c)object).a(a2)) return false;
            }
            return true;
        }

        public c fo() {
            return this;
        }

        @Override
        public /* synthetic */ Object freeze() {
            return this.fo();
        }

        @Override
        public String getUrl() {
            return this.iD;
        }

        int getVersionCode() {
            return this.kZ;
        }

        @Override
        public boolean hasUrl() {
            return this.zQ.contains(2);
        }

        public int hashCode() {
            Iterator<ee.a<?, ?>> iterator = zP.values().iterator();
            int n2 = 0;
            while (iterator.hasNext()) {
                ee.a<?, ?> a2 = iterator.next();
                if (!this.a(a2)) continue;
                int n3 = a2.bX();
                n2 = this.b(a2).hashCode() + (n2 + n3);
            }
            return n2;
        }

        @Override
        public boolean isDataValid() {
            return true;
        }

        public void writeToParcel(Parcel parcel, int n2) {
            hg hg2 = CREATOR;
            hg.a(this, parcel, n2);
        }
    }

    public static final class d
    extends ee
    implements SafeParcelable,
    Person.Name {
        public static final hh CREATOR = new hh();
        private static final HashMap<String, ee.a<?, ?>> zP = new HashMap();
        private String Ap;
        private String As;
        private String Bq;
        private String Br;
        private String Bs;
        private String Bt;
        private final int kZ;
        private final Set<Integer> zQ;

        static {
            zP.put("familyName", ee.a.f("familyName", 2));
            zP.put("formatted", ee.a.f("formatted", 3));
            zP.put("givenName", ee.a.f("givenName", 4));
            zP.put("honorificPrefix", ee.a.f("honorificPrefix", 5));
            zP.put("honorificSuffix", ee.a.f("honorificSuffix", 6));
            zP.put("middleName", ee.a.f("middleName", 7));
        }

        public d() {
            this.kZ = 1;
            this.zQ = new HashSet<Integer>();
        }

        d(Set<Integer> set, int n2, String string2, String string3, String string4, String string5, String string6, String string7) {
            this.zQ = set;
            this.kZ = n2;
            this.Ap = string2;
            this.Bq = string3;
            this.As = string4;
            this.Br = string5;
            this.Bs = string6;
            this.Bt = string7;
        }

        @Override
        protected Object J(String string2) {
            return null;
        }

        @Override
        protected boolean K(String string2) {
            return false;
        }

        @Override
        protected boolean a(ee.a a2) {
            return this.zQ.contains(a2.bX());
        }

        @Override
        protected Object b(ee.a a2) {
            switch (a2.bX()) {
                default: {
                    throw new IllegalStateException("Unknown safe parcelable id=" + a2.bX());
                }
                case 2: {
                    return this.Ap;
                }
                case 3: {
                    return this.Bq;
                }
                case 4: {
                    return this.As;
                }
                case 5: {
                    return this.Br;
                }
                case 6: {
                    return this.Bs;
                }
                case 7: 
            }
            return this.Bt;
        }

        @Override
        public HashMap<String, ee.a<?, ?>> bQ() {
            return zP;
        }

        public int describeContents() {
            hh hh2 = CREATOR;
            return 0;
        }

        Set<Integer> eF() {
            return this.zQ;
        }

        public boolean equals(Object object) {
            if (!(object instanceof d)) {
                return false;
            }
            if (this == object) {
                return true;
            }
            object = (d)object;
            Iterator<ee.a<?, ?>> iterator = zP.values().iterator();
            while (iterator.hasNext()) {
                ee.a<?, ?> a2 = iterator.next();
                if (this.a(a2)) {
                    if (!((d)object).a(a2)) return false;
                    if (this.b(a2).equals(((d)object).b(a2))) continue;
                    return false;
                }
                if (((d)object).a(a2)) return false;
            }
            return true;
        }

        public d fp() {
            return this;
        }

        @Override
        public /* synthetic */ Object freeze() {
            return this.fp();
        }

        @Override
        public String getFamilyName() {
            return this.Ap;
        }

        @Override
        public String getFormatted() {
            return this.Bq;
        }

        @Override
        public String getGivenName() {
            return this.As;
        }

        @Override
        public String getHonorificPrefix() {
            return this.Br;
        }

        @Override
        public String getHonorificSuffix() {
            return this.Bs;
        }

        @Override
        public String getMiddleName() {
            return this.Bt;
        }

        int getVersionCode() {
            return this.kZ;
        }

        @Override
        public boolean hasFamilyName() {
            return this.zQ.contains(2);
        }

        @Override
        public boolean hasFormatted() {
            return this.zQ.contains(3);
        }

        @Override
        public boolean hasGivenName() {
            return this.zQ.contains(4);
        }

        @Override
        public boolean hasHonorificPrefix() {
            return this.zQ.contains(5);
        }

        @Override
        public boolean hasHonorificSuffix() {
            return this.zQ.contains(6);
        }

        @Override
        public boolean hasMiddleName() {
            return this.zQ.contains(7);
        }

        public int hashCode() {
            Iterator<ee.a<?, ?>> iterator = zP.values().iterator();
            int n2 = 0;
            while (iterator.hasNext()) {
                ee.a<?, ?> a2 = iterator.next();
                if (!this.a(a2)) continue;
                int n3 = a2.bX();
                n2 = this.b(a2).hashCode() + (n2 + n3);
            }
            return n2;
        }

        @Override
        public boolean isDataValid() {
            return true;
        }

        public void writeToParcel(Parcel parcel, int n2) {
            hh hh2 = CREATOR;
            hh.a(this, parcel, n2);
        }
    }

    public static class e {
        public static int al(String string2) {
            if (string2.equals("person")) {
                return 0;
            }
            if (!string2.equals("page")) throw new IllegalArgumentException("Unknown objectType string: " + string2);
            return 1;
        }
    }

    public static final class f
    extends ee
    implements SafeParcelable,
    Person.Organizations {
        public static final hi CREATOR = new hi();
        private static final HashMap<String, ee.a<?, ?>> zP = new HashMap();
        private String AE;
        private String Ao;
        private String Bu;
        private String Bv;
        private boolean Bw;
        private final int kZ;
        private int lP;
        private String mName;
        private String oa;
        private String pZ;
        private final Set<Integer> zQ;

        static {
            zP.put("department", ee.a.f("department", 2));
            zP.put("description", ee.a.f("description", 3));
            zP.put("endDate", ee.a.f("endDate", 4));
            zP.put("location", ee.a.f("location", 5));
            zP.put("name", ee.a.f("name", 6));
            zP.put("primary", ee.a.e("primary", 7));
            zP.put("startDate", ee.a.f("startDate", 8));
            zP.put("title", ee.a.f("title", 9));
            zP.put("type", ee.a.a("type", 10, new eb().b("work", 0).b("school", 1), false));
        }

        public f() {
            this.kZ = 1;
            this.zQ = new HashSet<Integer>();
        }

        f(Set<Integer> set, int n2, String string2, String string3, String string4, String string5, String string6, boolean bl2, String string7, String string8, int n3) {
            this.zQ = set;
            this.kZ = n2;
            this.Bu = string2;
            this.pZ = string3;
            this.Ao = string4;
            this.Bv = string5;
            this.mName = string6;
            this.Bw = bl2;
            this.AE = string7;
            this.oa = string8;
            this.lP = n3;
        }

        @Override
        protected Object J(String string2) {
            return null;
        }

        @Override
        protected boolean K(String string2) {
            return false;
        }

        @Override
        protected boolean a(ee.a a2) {
            return this.zQ.contains(a2.bX());
        }

        @Override
        protected Object b(ee.a a2) {
            switch (a2.bX()) {
                default: {
                    throw new IllegalStateException("Unknown safe parcelable id=" + a2.bX());
                }
                case 2: {
                    return this.Bu;
                }
                case 3: {
                    return this.pZ;
                }
                case 4: {
                    return this.Ao;
                }
                case 5: {
                    return this.Bv;
                }
                case 6: {
                    return this.mName;
                }
                case 7: {
                    return this.Bw;
                }
                case 8: {
                    return this.AE;
                }
                case 9: {
                    return this.oa;
                }
                case 10: 
            }
            return this.lP;
        }

        @Override
        public HashMap<String, ee.a<?, ?>> bQ() {
            return zP;
        }

        public int describeContents() {
            hi hi2 = CREATOR;
            return 0;
        }

        Set<Integer> eF() {
            return this.zQ;
        }

        public boolean equals(Object object) {
            if (!(object instanceof f)) {
                return false;
            }
            if (this == object) {
                return true;
            }
            object = (f)object;
            Iterator<ee.a<?, ?>> iterator = zP.values().iterator();
            while (iterator.hasNext()) {
                ee.a<?, ?> a2 = iterator.next();
                if (this.a(a2)) {
                    if (!((f)object).a(a2)) return false;
                    if (this.b(a2).equals(((f)object).b(a2))) continue;
                    return false;
                }
                if (((f)object).a(a2)) return false;
            }
            return true;
        }

        public f fq() {
            return this;
        }

        @Override
        public /* synthetic */ Object freeze() {
            return this.fq();
        }

        @Override
        public String getDepartment() {
            return this.Bu;
        }

        @Override
        public String getDescription() {
            return this.pZ;
        }

        @Override
        public String getEndDate() {
            return this.Ao;
        }

        @Override
        public String getLocation() {
            return this.Bv;
        }

        @Override
        public String getName() {
            return this.mName;
        }

        @Override
        public String getStartDate() {
            return this.AE;
        }

        @Override
        public String getTitle() {
            return this.oa;
        }

        @Override
        public int getType() {
            return this.lP;
        }

        int getVersionCode() {
            return this.kZ;
        }

        @Override
        public boolean hasDepartment() {
            return this.zQ.contains(2);
        }

        @Override
        public boolean hasDescription() {
            return this.zQ.contains(3);
        }

        @Override
        public boolean hasEndDate() {
            return this.zQ.contains(4);
        }

        @Override
        public boolean hasLocation() {
            return this.zQ.contains(5);
        }

        @Override
        public boolean hasName() {
            return this.zQ.contains(6);
        }

        @Override
        public boolean hasPrimary() {
            return this.zQ.contains(7);
        }

        @Override
        public boolean hasStartDate() {
            return this.zQ.contains(8);
        }

        @Override
        public boolean hasTitle() {
            return this.zQ.contains(9);
        }

        @Override
        public boolean hasType() {
            return this.zQ.contains(10);
        }

        public int hashCode() {
            Iterator<ee.a<?, ?>> iterator = zP.values().iterator();
            int n2 = 0;
            while (iterator.hasNext()) {
                ee.a<?, ?> a2 = iterator.next();
                if (!this.a(a2)) continue;
                int n3 = a2.bX();
                n2 = this.b(a2).hashCode() + (n2 + n3);
            }
            return n2;
        }

        @Override
        public boolean isDataValid() {
            return true;
        }

        @Override
        public boolean isPrimary() {
            return this.Bw;
        }

        public void writeToParcel(Parcel parcel, int n2) {
            hi hi2 = CREATOR;
            hi.a(this, parcel, n2);
        }
    }

    public static final class g
    extends ee
    implements SafeParcelable,
    Person.PlacesLived {
        public static final hj CREATOR = new hj();
        private static final HashMap<String, ee.a<?, ?>> zP = new HashMap();
        private boolean Bw;
        private final int kZ;
        private String mValue;
        private final Set<Integer> zQ;

        static {
            zP.put("primary", ee.a.e("primary", 2));
            zP.put("value", ee.a.f("value", 3));
        }

        public g() {
            this.kZ = 1;
            this.zQ = new HashSet<Integer>();
        }

        g(Set<Integer> set, int n2, boolean bl2, String string2) {
            this.zQ = set;
            this.kZ = n2;
            this.Bw = bl2;
            this.mValue = string2;
        }

        @Override
        protected Object J(String string2) {
            return null;
        }

        @Override
        protected boolean K(String string2) {
            return false;
        }

        @Override
        protected boolean a(ee.a a2) {
            return this.zQ.contains(a2.bX());
        }

        @Override
        protected Object b(ee.a a2) {
            switch (a2.bX()) {
                default: {
                    throw new IllegalStateException("Unknown safe parcelable id=" + a2.bX());
                }
                case 2: {
                    return this.Bw;
                }
                case 3: 
            }
            return this.mValue;
        }

        @Override
        public HashMap<String, ee.a<?, ?>> bQ() {
            return zP;
        }

        public int describeContents() {
            hj hj2 = CREATOR;
            return 0;
        }

        Set<Integer> eF() {
            return this.zQ;
        }

        public boolean equals(Object object) {
            if (!(object instanceof g)) {
                return false;
            }
            if (this == object) {
                return true;
            }
            object = (g)object;
            Iterator<ee.a<?, ?>> iterator = zP.values().iterator();
            while (iterator.hasNext()) {
                ee.a<?, ?> a2 = iterator.next();
                if (this.a(a2)) {
                    if (!((g)object).a(a2)) return false;
                    if (this.b(a2).equals(((g)object).b(a2))) continue;
                    return false;
                }
                if (((g)object).a(a2)) return false;
            }
            return true;
        }

        public g fr() {
            return this;
        }

        @Override
        public /* synthetic */ Object freeze() {
            return this.fr();
        }

        @Override
        public String getValue() {
            return this.mValue;
        }

        int getVersionCode() {
            return this.kZ;
        }

        @Override
        public boolean hasPrimary() {
            return this.zQ.contains(2);
        }

        @Override
        public boolean hasValue() {
            return this.zQ.contains(3);
        }

        public int hashCode() {
            Iterator<ee.a<?, ?>> iterator = zP.values().iterator();
            int n2 = 0;
            while (iterator.hasNext()) {
                ee.a<?, ?> a2 = iterator.next();
                if (!this.a(a2)) continue;
                int n3 = a2.bX();
                n2 = this.b(a2).hashCode() + (n2 + n3);
            }
            return n2;
        }

        @Override
        public boolean isDataValid() {
            return true;
        }

        @Override
        public boolean isPrimary() {
            return this.Bw;
        }

        public void writeToParcel(Parcel parcel, int n2) {
            hj hj2 = CREATOR;
            hj.a(this, parcel, n2);
        }
    }

    public static final class h
    extends ee
    implements SafeParcelable,
    Person.Urls {
        public static final hk CREATOR = new hk();
        private static final HashMap<String, ee.a<?, ?>> zP = new HashMap();
        private String Bx;
        private final int By;
        private final int kZ;
        private int lP;
        private String mValue;
        private final Set<Integer> zQ;

        static {
            zP.put("label", ee.a.f("label", 5));
            zP.put("type", ee.a.a("type", 6, new eb().b("home", 0).b("work", 1).b("blog", 2).b("profile", 3).b("other", 4).b("otherProfile", 5).b("contributor", 6).b("website", 7), false));
            zP.put("value", ee.a.f("value", 4));
        }

        public h() {
            this.By = 4;
            this.kZ = 2;
            this.zQ = new HashSet<Integer>();
        }

        h(Set<Integer> set, int n2, String string2, int n3, String string3, int n4) {
            this.By = 4;
            this.zQ = set;
            this.kZ = n2;
            this.Bx = string2;
            this.lP = n3;
            this.mValue = string3;
        }

        @Override
        protected Object J(String string2) {
            return null;
        }

        @Override
        protected boolean K(String string2) {
            return false;
        }

        @Override
        protected boolean a(ee.a a2) {
            return this.zQ.contains(a2.bX());
        }

        @Override
        protected Object b(ee.a a2) {
            switch (a2.bX()) {
                default: {
                    throw new IllegalStateException("Unknown safe parcelable id=" + a2.bX());
                }
                case 5: {
                    return this.Bx;
                }
                case 6: {
                    return this.lP;
                }
                case 4: 
            }
            return this.mValue;
        }

        @Override
        public HashMap<String, ee.a<?, ?>> bQ() {
            return zP;
        }

        public int describeContents() {
            hk hk2 = CREATOR;
            return 0;
        }

        Set<Integer> eF() {
            return this.zQ;
        }

        public boolean equals(Object object) {
            if (!(object instanceof h)) {
                return false;
            }
            if (this == object) {
                return true;
            }
            object = (h)object;
            Iterator<ee.a<?, ?>> iterator = zP.values().iterator();
            while (iterator.hasNext()) {
                ee.a<?, ?> a2 = iterator.next();
                if (this.a(a2)) {
                    if (!((h)object).a(a2)) return false;
                    if (this.b(a2).equals(((h)object).b(a2))) continue;
                    return false;
                }
                if (((h)object).a(a2)) return false;
            }
            return true;
        }

        @Override
        public /* synthetic */ Object freeze() {
            return this.ft();
        }

        @Deprecated
        public int fs() {
            return 4;
        }

        public h ft() {
            return this;
        }

        @Override
        public String getLabel() {
            return this.Bx;
        }

        @Override
        public int getType() {
            return this.lP;
        }

        @Override
        public String getValue() {
            return this.mValue;
        }

        int getVersionCode() {
            return this.kZ;
        }

        @Override
        public boolean hasLabel() {
            return this.zQ.contains(5);
        }

        @Override
        public boolean hasType() {
            return this.zQ.contains(6);
        }

        @Override
        public boolean hasValue() {
            return this.zQ.contains(4);
        }

        public int hashCode() {
            Iterator<ee.a<?, ?>> iterator = zP.values().iterator();
            int n2 = 0;
            while (iterator.hasNext()) {
                ee.a<?, ?> a2 = iterator.next();
                if (!this.a(a2)) continue;
                int n3 = a2.bX();
                n2 = this.b(a2).hashCode() + (n2 + n3);
            }
            return n2;
        }

        @Override
        public boolean isDataValid() {
            return true;
        }

        public void writeToParcel(Parcel parcel, int n2) {
            hk hk2 = CREATOR;
            hk.a(this, parcel, n2);
        }
    }
}

