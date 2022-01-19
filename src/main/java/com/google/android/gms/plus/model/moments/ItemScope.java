/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.plus.model.moments;

import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.internal.gv;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface ItemScope
extends Freezable<ItemScope> {
    public ItemScope getAbout();

    public List<String> getAdditionalName();

    public ItemScope getAddress();

    public String getAddressCountry();

    public String getAddressLocality();

    public String getAddressRegion();

    public List<ItemScope> getAssociated_media();

    public int getAttendeeCount();

    public List<ItemScope> getAttendees();

    public ItemScope getAudio();

    public List<ItemScope> getAuthor();

    public String getBestRating();

    public String getBirthDate();

    public ItemScope getByArtist();

    public String getCaption();

    public String getContentSize();

    public String getContentUrl();

    public List<ItemScope> getContributor();

    public String getDateCreated();

    public String getDateModified();

    public String getDatePublished();

    public String getDescription();

    public String getDuration();

    public String getEmbedUrl();

    public String getEndDate();

    public String getFamilyName();

    public String getGender();

    public ItemScope getGeo();

    public String getGivenName();

    public String getHeight();

    public String getId();

    public String getImage();

    public ItemScope getInAlbum();

    public double getLatitude();

    public ItemScope getLocation();

    public double getLongitude();

    public String getName();

    public ItemScope getPartOfTVSeries();

    public List<ItemScope> getPerformers();

    public String getPlayerType();

    public String getPostOfficeBoxNumber();

    public String getPostalCode();

    public String getRatingValue();

    public ItemScope getReviewRating();

    public String getStartDate();

    public String getStreetAddress();

    public String getText();

    public ItemScope getThumbnail();

    public String getThumbnailUrl();

    public String getTickerSymbol();

    public String getType();

    public String getUrl();

    public String getWidth();

    public String getWorstRating();

    public boolean hasAbout();

    public boolean hasAdditionalName();

    public boolean hasAddress();

    public boolean hasAddressCountry();

    public boolean hasAddressLocality();

    public boolean hasAddressRegion();

    public boolean hasAssociated_media();

    public boolean hasAttendeeCount();

    public boolean hasAttendees();

    public boolean hasAudio();

    public boolean hasAuthor();

    public boolean hasBestRating();

    public boolean hasBirthDate();

    public boolean hasByArtist();

    public boolean hasCaption();

    public boolean hasContentSize();

    public boolean hasContentUrl();

    public boolean hasContributor();

    public boolean hasDateCreated();

    public boolean hasDateModified();

    public boolean hasDatePublished();

    public boolean hasDescription();

    public boolean hasDuration();

    public boolean hasEmbedUrl();

    public boolean hasEndDate();

    public boolean hasFamilyName();

    public boolean hasGender();

    public boolean hasGeo();

    public boolean hasGivenName();

    public boolean hasHeight();

    public boolean hasId();

    public boolean hasImage();

    public boolean hasInAlbum();

    public boolean hasLatitude();

    public boolean hasLocation();

    public boolean hasLongitude();

    public boolean hasName();

    public boolean hasPartOfTVSeries();

    public boolean hasPerformers();

    public boolean hasPlayerType();

    public boolean hasPostOfficeBoxNumber();

    public boolean hasPostalCode();

    public boolean hasRatingValue();

    public boolean hasReviewRating();

    public boolean hasStartDate();

    public boolean hasStreetAddress();

    public boolean hasText();

    public boolean hasThumbnail();

    public boolean hasThumbnailUrl();

    public boolean hasTickerSymbol();

    public boolean hasType();

    public boolean hasUrl();

    public boolean hasWidth();

    public boolean hasWorstRating();

    public static class Builder {
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
        private String mName;
        private String pZ;
        private double tC;
        private double tD;
        private String wF;
        private String wJ;
        private final Set<Integer> zQ = new HashSet<Integer>();
        private gv zR;
        private List<String> zS;
        private gv zT;
        private String zU;
        private String zV;
        private String zW;
        private List<gv> zX;
        private int zY;
        private List<gv> zZ;

        public ItemScope build() {
            return new gv(this.zQ, this.zR, this.zS, this.zT, this.zU, this.zV, this.zW, this.zX, this.zY, this.zZ, this.Aa, this.Ab, this.Ac, this.Ad, this.Ae, this.Af, this.Ag, this.Ah, this.Ai, this.Aj, this.Ak, this.Al, this.pZ, this.Am, this.An, this.Ao, this.Ap, this.Aq, this.Ar, this.As, this.At, this.wJ, this.Au, this.Av, this.tC, this.Aw, this.tD, this.mName, this.Ax, this.Ay, this.Az, this.AA, this.AB, this.AC, this.AD, this.AE, this.AF, this.AG, this.AH, this.AI, this.AJ, this.wF, this.iD, this.AK, this.AL);
        }

        public Builder setAbout(ItemScope itemScope) {
            this.zR = (gv)itemScope;
            this.zQ.add(2);
            return this;
        }

        public Builder setAdditionalName(List<String> list) {
            this.zS = list;
            this.zQ.add(3);
            return this;
        }

        public Builder setAddress(ItemScope itemScope) {
            this.zT = (gv)itemScope;
            this.zQ.add(4);
            return this;
        }

        public Builder setAddressCountry(String string2) {
            this.zU = string2;
            this.zQ.add(5);
            return this;
        }

        public Builder setAddressLocality(String string2) {
            this.zV = string2;
            this.zQ.add(6);
            return this;
        }

        public Builder setAddressRegion(String string2) {
            this.zW = string2;
            this.zQ.add(7);
            return this;
        }

        public Builder setAssociated_media(List<ItemScope> list) {
            this.zX = list;
            this.zQ.add(8);
            return this;
        }

        public Builder setAttendeeCount(int n2) {
            this.zY = n2;
            this.zQ.add(9);
            return this;
        }

        public Builder setAttendees(List<ItemScope> list) {
            this.zZ = list;
            this.zQ.add(10);
            return this;
        }

        public Builder setAudio(ItemScope itemScope) {
            this.Aa = (gv)itemScope;
            this.zQ.add(11);
            return this;
        }

        public Builder setAuthor(List<ItemScope> list) {
            this.Ab = list;
            this.zQ.add(12);
            return this;
        }

        public Builder setBestRating(String string2) {
            this.Ac = string2;
            this.zQ.add(13);
            return this;
        }

        public Builder setBirthDate(String string2) {
            this.Ad = string2;
            this.zQ.add(14);
            return this;
        }

        public Builder setByArtist(ItemScope itemScope) {
            this.Ae = (gv)itemScope;
            this.zQ.add(15);
            return this;
        }

        public Builder setCaption(String string2) {
            this.Af = string2;
            this.zQ.add(16);
            return this;
        }

        public Builder setContentSize(String string2) {
            this.Ag = string2;
            this.zQ.add(17);
            return this;
        }

        public Builder setContentUrl(String string2) {
            this.Ah = string2;
            this.zQ.add(18);
            return this;
        }

        public Builder setContributor(List<ItemScope> list) {
            this.Ai = list;
            this.zQ.add(19);
            return this;
        }

        public Builder setDateCreated(String string2) {
            this.Aj = string2;
            this.zQ.add(20);
            return this;
        }

        public Builder setDateModified(String string2) {
            this.Ak = string2;
            this.zQ.add(21);
            return this;
        }

        public Builder setDatePublished(String string2) {
            this.Al = string2;
            this.zQ.add(22);
            return this;
        }

        public Builder setDescription(String string2) {
            this.pZ = string2;
            this.zQ.add(23);
            return this;
        }

        public Builder setDuration(String string2) {
            this.Am = string2;
            this.zQ.add(24);
            return this;
        }

        public Builder setEmbedUrl(String string2) {
            this.An = string2;
            this.zQ.add(25);
            return this;
        }

        public Builder setEndDate(String string2) {
            this.Ao = string2;
            this.zQ.add(26);
            return this;
        }

        public Builder setFamilyName(String string2) {
            this.Ap = string2;
            this.zQ.add(27);
            return this;
        }

        public Builder setGender(String string2) {
            this.Aq = string2;
            this.zQ.add(28);
            return this;
        }

        public Builder setGeo(ItemScope itemScope) {
            this.Ar = (gv)itemScope;
            this.zQ.add(29);
            return this;
        }

        public Builder setGivenName(String string2) {
            this.As = string2;
            this.zQ.add(30);
            return this;
        }

        public Builder setHeight(String string2) {
            this.At = string2;
            this.zQ.add(31);
            return this;
        }

        public Builder setId(String string2) {
            this.wJ = string2;
            this.zQ.add(32);
            return this;
        }

        public Builder setImage(String string2) {
            this.Au = string2;
            this.zQ.add(33);
            return this;
        }

        public Builder setInAlbum(ItemScope itemScope) {
            this.Av = (gv)itemScope;
            this.zQ.add(34);
            return this;
        }

        public Builder setLatitude(double d2) {
            this.tC = d2;
            this.zQ.add(36);
            return this;
        }

        public Builder setLocation(ItemScope itemScope) {
            this.Aw = (gv)itemScope;
            this.zQ.add(37);
            return this;
        }

        public Builder setLongitude(double d2) {
            this.tD = d2;
            this.zQ.add(38);
            return this;
        }

        public Builder setName(String string2) {
            this.mName = string2;
            this.zQ.add(39);
            return this;
        }

        public Builder setPartOfTVSeries(ItemScope itemScope) {
            this.Ax = (gv)itemScope;
            this.zQ.add(40);
            return this;
        }

        public Builder setPerformers(List<ItemScope> list) {
            this.Ay = list;
            this.zQ.add(41);
            return this;
        }

        public Builder setPlayerType(String string2) {
            this.Az = string2;
            this.zQ.add(42);
            return this;
        }

        public Builder setPostOfficeBoxNumber(String string2) {
            this.AA = string2;
            this.zQ.add(43);
            return this;
        }

        public Builder setPostalCode(String string2) {
            this.AB = string2;
            this.zQ.add(44);
            return this;
        }

        public Builder setRatingValue(String string2) {
            this.AC = string2;
            this.zQ.add(45);
            return this;
        }

        public Builder setReviewRating(ItemScope itemScope) {
            this.AD = (gv)itemScope;
            this.zQ.add(46);
            return this;
        }

        public Builder setStartDate(String string2) {
            this.AE = string2;
            this.zQ.add(47);
            return this;
        }

        public Builder setStreetAddress(String string2) {
            this.AF = string2;
            this.zQ.add(48);
            return this;
        }

        public Builder setText(String string2) {
            this.AG = string2;
            this.zQ.add(49);
            return this;
        }

        public Builder setThumbnail(ItemScope itemScope) {
            this.AH = (gv)itemScope;
            this.zQ.add(50);
            return this;
        }

        public Builder setThumbnailUrl(String string2) {
            this.AI = string2;
            this.zQ.add(51);
            return this;
        }

        public Builder setTickerSymbol(String string2) {
            this.AJ = string2;
            this.zQ.add(52);
            return this;
        }

        public Builder setType(String string2) {
            this.wF = string2;
            this.zQ.add(53);
            return this;
        }

        public Builder setUrl(String string2) {
            this.iD = string2;
            this.zQ.add(54);
            return this;
        }

        public Builder setWidth(String string2) {
            this.AK = string2;
            this.zQ.add(55);
            return this;
        }

        public Builder setWorstRating(String string2) {
            this.AL = string2;
            this.zQ.add(56);
            return this;
        }
    }
}

