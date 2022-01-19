/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 */
package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ee;
import com.google.android.gms.internal.gw;
import com.google.android.gms.plus.model.moments.ItemScope;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class gv
extends ee
implements SafeParcelable,
ItemScope {
    public static final gw CREATOR = new gw();
    private static final HashMap<String, ee.a<?, ?>> zP = new HashMap();
    private String AA;
    private String AB;
    private String AC;
    private gv AD;
    private String AE;
    private String AF;
    private String AG;
    private gv AH;
    private String AI;
    private String AJ;
    private String AK;
    private String AL;
    private gv Aa;
    private List<gv> Ab;
    private String Ac;
    private String Ad;
    private gv Ae;
    private String Af;
    private String Ag;
    private String Ah;
    private List<gv> Ai;
    private String Aj;
    private String Ak;
    private String Al;
    private String Am;
    private String An;
    private String Ao;
    private String Ap;
    private String Aq;
    private gv Ar;
    private String As;
    private String At;
    private String Au;
    private gv Av;
    private gv Aw;
    private gv Ax;
    private List<gv> Ay;
    private String Az;
    private String iD;
    private final int kZ;
    private String mName;
    private String pZ;
    private double tC;
    private double tD;
    private String wF;
    private String wJ;
    private final Set<Integer> zQ;
    private gv zR;
    private List<String> zS;
    private gv zT;
    private String zU;
    private String zV;
    private String zW;
    private List<gv> zX;
    private int zY;
    private List<gv> zZ;

    static {
        zP.put("about", ee.a.a("about", 2, gv.class));
        zP.put("additionalName", ee.a.g("additionalName", 3));
        zP.put("address", ee.a.a("address", 4, gv.class));
        zP.put("addressCountry", ee.a.f("addressCountry", 5));
        zP.put("addressLocality", ee.a.f("addressLocality", 6));
        zP.put("addressRegion", ee.a.f("addressRegion", 7));
        zP.put("associated_media", ee.a.b("associated_media", 8, gv.class));
        zP.put("attendeeCount", ee.a.c("attendeeCount", 9));
        zP.put("attendees", ee.a.b("attendees", 10, gv.class));
        zP.put("audio", ee.a.a("audio", 11, gv.class));
        zP.put("author", ee.a.b("author", 12, gv.class));
        zP.put("bestRating", ee.a.f("bestRating", 13));
        zP.put("birthDate", ee.a.f("birthDate", 14));
        zP.put("byArtist", ee.a.a("byArtist", 15, gv.class));
        zP.put("caption", ee.a.f("caption", 16));
        zP.put("contentSize", ee.a.f("contentSize", 17));
        zP.put("contentUrl", ee.a.f("contentUrl", 18));
        zP.put("contributor", ee.a.b("contributor", 19, gv.class));
        zP.put("dateCreated", ee.a.f("dateCreated", 20));
        zP.put("dateModified", ee.a.f("dateModified", 21));
        zP.put("datePublished", ee.a.f("datePublished", 22));
        zP.put("description", ee.a.f("description", 23));
        zP.put("duration", ee.a.f("duration", 24));
        zP.put("embedUrl", ee.a.f("embedUrl", 25));
        zP.put("endDate", ee.a.f("endDate", 26));
        zP.put("familyName", ee.a.f("familyName", 27));
        zP.put("gender", ee.a.f("gender", 28));
        zP.put("geo", ee.a.a("geo", 29, gv.class));
        zP.put("givenName", ee.a.f("givenName", 30));
        zP.put("height", ee.a.f("height", 31));
        zP.put("id", ee.a.f("id", 32));
        zP.put("image", ee.a.f("image", 33));
        zP.put("inAlbum", ee.a.a("inAlbum", 34, gv.class));
        zP.put("latitude", ee.a.d("latitude", 36));
        zP.put("location", ee.a.a("location", 37, gv.class));
        zP.put("longitude", ee.a.d("longitude", 38));
        zP.put("name", ee.a.f("name", 39));
        zP.put("partOfTVSeries", ee.a.a("partOfTVSeries", 40, gv.class));
        zP.put("performers", ee.a.b("performers", 41, gv.class));
        zP.put("playerType", ee.a.f("playerType", 42));
        zP.put("postOfficeBoxNumber", ee.a.f("postOfficeBoxNumber", 43));
        zP.put("postalCode", ee.a.f("postalCode", 44));
        zP.put("ratingValue", ee.a.f("ratingValue", 45));
        zP.put("reviewRating", ee.a.a("reviewRating", 46, gv.class));
        zP.put("startDate", ee.a.f("startDate", 47));
        zP.put("streetAddress", ee.a.f("streetAddress", 48));
        zP.put("text", ee.a.f("text", 49));
        zP.put("thumbnail", ee.a.a("thumbnail", 50, gv.class));
        zP.put("thumbnailUrl", ee.a.f("thumbnailUrl", 51));
        zP.put("tickerSymbol", ee.a.f("tickerSymbol", 52));
        zP.put("type", ee.a.f("type", 53));
        zP.put("url", ee.a.f("url", 54));
        zP.put("width", ee.a.f("width", 55));
        zP.put("worstRating", ee.a.f("worstRating", 56));
    }

    public gv() {
        this.kZ = 1;
        this.zQ = new HashSet<Integer>();
    }

    gv(Set<Integer> set, int n2, gv gv2, List<String> list, gv gv3, String string2, String string3, String string4, List<gv> list2, int n3, List<gv> list3, gv gv4, List<gv> list4, String string5, String string6, gv gv5, String string7, String string8, String string9, List<gv> list5, String string10, String string11, String string12, String string13, String string14, String string15, String string16, String string17, String string18, gv gv6, String string19, String string20, String string21, String string22, gv gv7, double d2, gv gv8, double d3, String string23, gv gv9, List<gv> list6, String string24, String string25, String string26, String string27, gv gv10, String string28, String string29, String string30, gv gv11, String string31, String string32, String string33, String string34, String string35, String string36) {
        this.zQ = set;
        this.kZ = n2;
        this.zR = gv2;
        this.zS = list;
        this.zT = gv3;
        this.zU = string2;
        this.zV = string3;
        this.zW = string4;
        this.zX = list2;
        this.zY = n3;
        this.zZ = list3;
        this.Aa = gv4;
        this.Ab = list4;
        this.Ac = string5;
        this.Ad = string6;
        this.Ae = gv5;
        this.Af = string7;
        this.Ag = string8;
        this.Ah = string9;
        this.Ai = list5;
        this.Aj = string10;
        this.Ak = string11;
        this.Al = string12;
        this.pZ = string13;
        this.Am = string14;
        this.An = string15;
        this.Ao = string16;
        this.Ap = string17;
        this.Aq = string18;
        this.Ar = gv6;
        this.As = string19;
        this.At = string20;
        this.wJ = string21;
        this.Au = string22;
        this.Av = gv7;
        this.tC = d2;
        this.Aw = gv8;
        this.tD = d3;
        this.mName = string23;
        this.Ax = gv9;
        this.Ay = list6;
        this.Az = string24;
        this.AA = string25;
        this.AB = string26;
        this.AC = string27;
        this.AD = gv10;
        this.AE = string28;
        this.AF = string29;
        this.AG = string30;
        this.AH = gv11;
        this.AI = string31;
        this.AJ = string32;
        this.wF = string33;
        this.iD = string34;
        this.AK = string35;
        this.AL = string36;
    }

    public gv(Set<Integer> set, gv gv2, List<String> list, gv gv3, String string2, String string3, String string4, List<gv> list2, int n2, List<gv> list3, gv gv4, List<gv> list4, String string5, String string6, gv gv5, String string7, String string8, String string9, List<gv> list5, String string10, String string11, String string12, String string13, String string14, String string15, String string16, String string17, String string18, gv gv6, String string19, String string20, String string21, String string22, gv gv7, double d2, gv gv8, double d3, String string23, gv gv9, List<gv> list6, String string24, String string25, String string26, String string27, gv gv10, String string28, String string29, String string30, gv gv11, String string31, String string32, String string33, String string34, String string35, String string36) {
        this.zQ = set;
        this.kZ = 1;
        this.zR = gv2;
        this.zS = list;
        this.zT = gv3;
        this.zU = string2;
        this.zV = string3;
        this.zW = string4;
        this.zX = list2;
        this.zY = n2;
        this.zZ = list3;
        this.Aa = gv4;
        this.Ab = list4;
        this.Ac = string5;
        this.Ad = string6;
        this.Ae = gv5;
        this.Af = string7;
        this.Ag = string8;
        this.Ah = string9;
        this.Ai = list5;
        this.Aj = string10;
        this.Ak = string11;
        this.Al = string12;
        this.pZ = string13;
        this.Am = string14;
        this.An = string15;
        this.Ao = string16;
        this.Ap = string17;
        this.Aq = string18;
        this.Ar = gv6;
        this.As = string19;
        this.At = string20;
        this.wJ = string21;
        this.Au = string22;
        this.Av = gv7;
        this.tC = d2;
        this.Aw = gv8;
        this.tD = d3;
        this.mName = string23;
        this.Ax = gv9;
        this.Ay = list6;
        this.Az = string24;
        this.AA = string25;
        this.AB = string26;
        this.AC = string27;
        this.AD = gv10;
        this.AE = string28;
        this.AF = string29;
        this.AG = string30;
        this.AH = gv11;
        this.AI = string31;
        this.AJ = string32;
        this.wF = string33;
        this.iD = string34;
        this.AK = string35;
        this.AL = string36;
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
                return this.zR;
            }
            case 3: {
                return this.zS;
            }
            case 4: {
                return this.zT;
            }
            case 5: {
                return this.zU;
            }
            case 6: {
                return this.zV;
            }
            case 7: {
                return this.zW;
            }
            case 8: {
                return this.zX;
            }
            case 9: {
                return this.zY;
            }
            case 10: {
                return this.zZ;
            }
            case 11: {
                return this.Aa;
            }
            case 12: {
                return this.Ab;
            }
            case 13: {
                return this.Ac;
            }
            case 14: {
                return this.Ad;
            }
            case 15: {
                return this.Ae;
            }
            case 16: {
                return this.Af;
            }
            case 17: {
                return this.Ag;
            }
            case 18: {
                return this.Ah;
            }
            case 19: {
                return this.Ai;
            }
            case 20: {
                return this.Aj;
            }
            case 21: {
                return this.Ak;
            }
            case 22: {
                return this.Al;
            }
            case 23: {
                return this.pZ;
            }
            case 24: {
                return this.Am;
            }
            case 25: {
                return this.An;
            }
            case 26: {
                return this.Ao;
            }
            case 27: {
                return this.Ap;
            }
            case 28: {
                return this.Aq;
            }
            case 29: {
                return this.Ar;
            }
            case 30: {
                return this.As;
            }
            case 31: {
                return this.At;
            }
            case 32: {
                return this.wJ;
            }
            case 33: {
                return this.Au;
            }
            case 34: {
                return this.Av;
            }
            case 36: {
                return this.tC;
            }
            case 37: {
                return this.Aw;
            }
            case 38: {
                return this.tD;
            }
            case 39: {
                return this.mName;
            }
            case 40: {
                return this.Ax;
            }
            case 41: {
                return this.Ay;
            }
            case 42: {
                return this.Az;
            }
            case 43: {
                return this.AA;
            }
            case 44: {
                return this.AB;
            }
            case 45: {
                return this.AC;
            }
            case 46: {
                return this.AD;
            }
            case 47: {
                return this.AE;
            }
            case 48: {
                return this.AF;
            }
            case 49: {
                return this.AG;
            }
            case 50: {
                return this.AH;
            }
            case 51: {
                return this.AI;
            }
            case 52: {
                return this.AJ;
            }
            case 53: {
                return this.wF;
            }
            case 54: {
                return this.iD;
            }
            case 55: {
                return this.AK;
            }
            case 56: 
        }
        return this.AL;
    }

    @Override
    public HashMap<String, ee.a<?, ?>> bQ() {
        return zP;
    }

    public int describeContents() {
        gw gw2 = CREATOR;
        return 0;
    }

    Set<Integer> eF() {
        return this.zQ;
    }

    gv eG() {
        return this.zR;
    }

    gv eH() {
        return this.zT;
    }

    List<gv> eI() {
        return this.zX;
    }

    List<gv> eJ() {
        return this.zZ;
    }

    gv eK() {
        return this.Aa;
    }

    List<gv> eL() {
        return this.Ab;
    }

    gv eM() {
        return this.Ae;
    }

    List<gv> eN() {
        return this.Ai;
    }

    gv eO() {
        return this.Ar;
    }

    gv eP() {
        return this.Av;
    }

    gv eQ() {
        return this.Aw;
    }

    gv eR() {
        return this.Ax;
    }

    List<gv> eS() {
        return this.Ay;
    }

    gv eT() {
        return this.AD;
    }

    gv eU() {
        return this.AH;
    }

    public gv eV() {
        return this;
    }

    public boolean equals(Object object) {
        if (!(object instanceof gv)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        object = (gv)object;
        Iterator<ee.a<?, ?>> iterator = zP.values().iterator();
        while (iterator.hasNext()) {
            ee.a<?, ?> a2 = iterator.next();
            if (this.a(a2)) {
                if (!((gv)object).a(a2)) return false;
                if (this.b(a2).equals(((gv)object).b(a2))) continue;
                return false;
            }
            if (((gv)object).a(a2)) return false;
        }
        return true;
    }

    @Override
    public /* synthetic */ Object freeze() {
        return this.eV();
    }

    @Override
    public ItemScope getAbout() {
        return this.zR;
    }

    @Override
    public List<String> getAdditionalName() {
        return this.zS;
    }

    @Override
    public ItemScope getAddress() {
        return this.zT;
    }

    @Override
    public String getAddressCountry() {
        return this.zU;
    }

    @Override
    public String getAddressLocality() {
        return this.zV;
    }

    @Override
    public String getAddressRegion() {
        return this.zW;
    }

    @Override
    public List<ItemScope> getAssociated_media() {
        return (ArrayList)this.zX;
    }

    @Override
    public int getAttendeeCount() {
        return this.zY;
    }

    @Override
    public List<ItemScope> getAttendees() {
        return (ArrayList)this.zZ;
    }

    @Override
    public ItemScope getAudio() {
        return this.Aa;
    }

    @Override
    public List<ItemScope> getAuthor() {
        return (ArrayList)this.Ab;
    }

    @Override
    public String getBestRating() {
        return this.Ac;
    }

    @Override
    public String getBirthDate() {
        return this.Ad;
    }

    @Override
    public ItemScope getByArtist() {
        return this.Ae;
    }

    @Override
    public String getCaption() {
        return this.Af;
    }

    @Override
    public String getContentSize() {
        return this.Ag;
    }

    @Override
    public String getContentUrl() {
        return this.Ah;
    }

    @Override
    public List<ItemScope> getContributor() {
        return (ArrayList)this.Ai;
    }

    @Override
    public String getDateCreated() {
        return this.Aj;
    }

    @Override
    public String getDateModified() {
        return this.Ak;
    }

    @Override
    public String getDatePublished() {
        return this.Al;
    }

    @Override
    public String getDescription() {
        return this.pZ;
    }

    @Override
    public String getDuration() {
        return this.Am;
    }

    @Override
    public String getEmbedUrl() {
        return this.An;
    }

    @Override
    public String getEndDate() {
        return this.Ao;
    }

    @Override
    public String getFamilyName() {
        return this.Ap;
    }

    @Override
    public String getGender() {
        return this.Aq;
    }

    @Override
    public ItemScope getGeo() {
        return this.Ar;
    }

    @Override
    public String getGivenName() {
        return this.As;
    }

    @Override
    public String getHeight() {
        return this.At;
    }

    @Override
    public String getId() {
        return this.wJ;
    }

    @Override
    public String getImage() {
        return this.Au;
    }

    @Override
    public ItemScope getInAlbum() {
        return this.Av;
    }

    @Override
    public double getLatitude() {
        return this.tC;
    }

    @Override
    public ItemScope getLocation() {
        return this.Aw;
    }

    @Override
    public double getLongitude() {
        return this.tD;
    }

    @Override
    public String getName() {
        return this.mName;
    }

    @Override
    public ItemScope getPartOfTVSeries() {
        return this.Ax;
    }

    @Override
    public List<ItemScope> getPerformers() {
        return (ArrayList)this.Ay;
    }

    @Override
    public String getPlayerType() {
        return this.Az;
    }

    @Override
    public String getPostOfficeBoxNumber() {
        return this.AA;
    }

    @Override
    public String getPostalCode() {
        return this.AB;
    }

    @Override
    public String getRatingValue() {
        return this.AC;
    }

    @Override
    public ItemScope getReviewRating() {
        return this.AD;
    }

    @Override
    public String getStartDate() {
        return this.AE;
    }

    @Override
    public String getStreetAddress() {
        return this.AF;
    }

    @Override
    public String getText() {
        return this.AG;
    }

    @Override
    public ItemScope getThumbnail() {
        return this.AH;
    }

    @Override
    public String getThumbnailUrl() {
        return this.AI;
    }

    @Override
    public String getTickerSymbol() {
        return this.AJ;
    }

    @Override
    public String getType() {
        return this.wF;
    }

    @Override
    public String getUrl() {
        return this.iD;
    }

    int getVersionCode() {
        return this.kZ;
    }

    @Override
    public String getWidth() {
        return this.AK;
    }

    @Override
    public String getWorstRating() {
        return this.AL;
    }

    @Override
    public boolean hasAbout() {
        return this.zQ.contains(2);
    }

    @Override
    public boolean hasAdditionalName() {
        return this.zQ.contains(3);
    }

    @Override
    public boolean hasAddress() {
        return this.zQ.contains(4);
    }

    @Override
    public boolean hasAddressCountry() {
        return this.zQ.contains(5);
    }

    @Override
    public boolean hasAddressLocality() {
        return this.zQ.contains(6);
    }

    @Override
    public boolean hasAddressRegion() {
        return this.zQ.contains(7);
    }

    @Override
    public boolean hasAssociated_media() {
        return this.zQ.contains(8);
    }

    @Override
    public boolean hasAttendeeCount() {
        return this.zQ.contains(9);
    }

    @Override
    public boolean hasAttendees() {
        return this.zQ.contains(10);
    }

    @Override
    public boolean hasAudio() {
        return this.zQ.contains(11);
    }

    @Override
    public boolean hasAuthor() {
        return this.zQ.contains(12);
    }

    @Override
    public boolean hasBestRating() {
        return this.zQ.contains(13);
    }

    @Override
    public boolean hasBirthDate() {
        return this.zQ.contains(14);
    }

    @Override
    public boolean hasByArtist() {
        return this.zQ.contains(15);
    }

    @Override
    public boolean hasCaption() {
        return this.zQ.contains(16);
    }

    @Override
    public boolean hasContentSize() {
        return this.zQ.contains(17);
    }

    @Override
    public boolean hasContentUrl() {
        return this.zQ.contains(18);
    }

    @Override
    public boolean hasContributor() {
        return this.zQ.contains(19);
    }

    @Override
    public boolean hasDateCreated() {
        return this.zQ.contains(20);
    }

    @Override
    public boolean hasDateModified() {
        return this.zQ.contains(21);
    }

    @Override
    public boolean hasDatePublished() {
        return this.zQ.contains(22);
    }

    @Override
    public boolean hasDescription() {
        return this.zQ.contains(23);
    }

    @Override
    public boolean hasDuration() {
        return this.zQ.contains(24);
    }

    @Override
    public boolean hasEmbedUrl() {
        return this.zQ.contains(25);
    }

    @Override
    public boolean hasEndDate() {
        return this.zQ.contains(26);
    }

    @Override
    public boolean hasFamilyName() {
        return this.zQ.contains(27);
    }

    @Override
    public boolean hasGender() {
        return this.zQ.contains(28);
    }

    @Override
    public boolean hasGeo() {
        return this.zQ.contains(29);
    }

    @Override
    public boolean hasGivenName() {
        return this.zQ.contains(30);
    }

    @Override
    public boolean hasHeight() {
        return this.zQ.contains(31);
    }

    @Override
    public boolean hasId() {
        return this.zQ.contains(32);
    }

    @Override
    public boolean hasImage() {
        return this.zQ.contains(33);
    }

    @Override
    public boolean hasInAlbum() {
        return this.zQ.contains(34);
    }

    @Override
    public boolean hasLatitude() {
        return this.zQ.contains(36);
    }

    @Override
    public boolean hasLocation() {
        return this.zQ.contains(37);
    }

    @Override
    public boolean hasLongitude() {
        return this.zQ.contains(38);
    }

    @Override
    public boolean hasName() {
        return this.zQ.contains(39);
    }

    @Override
    public boolean hasPartOfTVSeries() {
        return this.zQ.contains(40);
    }

    @Override
    public boolean hasPerformers() {
        return this.zQ.contains(41);
    }

    @Override
    public boolean hasPlayerType() {
        return this.zQ.contains(42);
    }

    @Override
    public boolean hasPostOfficeBoxNumber() {
        return this.zQ.contains(43);
    }

    @Override
    public boolean hasPostalCode() {
        return this.zQ.contains(44);
    }

    @Override
    public boolean hasRatingValue() {
        return this.zQ.contains(45);
    }

    @Override
    public boolean hasReviewRating() {
        return this.zQ.contains(46);
    }

    @Override
    public boolean hasStartDate() {
        return this.zQ.contains(47);
    }

    @Override
    public boolean hasStreetAddress() {
        return this.zQ.contains(48);
    }

    @Override
    public boolean hasText() {
        return this.zQ.contains(49);
    }

    @Override
    public boolean hasThumbnail() {
        return this.zQ.contains(50);
    }

    @Override
    public boolean hasThumbnailUrl() {
        return this.zQ.contains(51);
    }

    @Override
    public boolean hasTickerSymbol() {
        return this.zQ.contains(52);
    }

    @Override
    public boolean hasType() {
        return this.zQ.contains(53);
    }

    @Override
    public boolean hasUrl() {
        return this.zQ.contains(54);
    }

    @Override
    public boolean hasWidth() {
        return this.zQ.contains(55);
    }

    @Override
    public boolean hasWorstRating() {
        return this.zQ.contains(56);
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
        gw gw2 = CREATOR;
        gw.a(this, parcel, n2);
    }
}

