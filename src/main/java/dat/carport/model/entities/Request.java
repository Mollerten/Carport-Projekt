package dat.carport.model.entities;

import java.util.Objects;

public class Request {
    int requestid;
    int lengthcp;
    int widthcp;
    int lengthrr;
    int widthrr;
    String roofmat;
    String woodcladding;
    double totalPrice = 0;
    int customerid;
    int adminid;

    public Request(int lengthcp, int widthcp, int lengthrr, int widthrr, String roofmat, String woodcladding, int customerid) {
        this.lengthcp = lengthcp;
        this.widthcp = widthcp;
        this.lengthrr = lengthrr;
        this.widthrr = widthrr;
        this.roofmat = roofmat;
        this.woodcladding = woodcladding;
        this.customerid = customerid;
    }

    public Request(int requestid, int lengthcp, int widthcp, int lengthrr, int widthrr, String roofmat, String woodcladding, int customerid, int adminid) {
        this.requestid = requestid;
        this.lengthcp = lengthcp;
        this.widthcp = widthcp;
        this.lengthrr = lengthrr;
        this.widthrr = widthrr;
        this.roofmat = roofmat;
        this.woodcladding = woodcladding;
        this.customerid = customerid;
        this.adminid = adminid;
    }

    public Request(int requestid, int lengthcp, int widthcp, int lengthrr, int widthrr, String roofmat, String woodcladding, double totalPrice, int customerid, int adminid) {
        this.requestid = requestid;
        this.lengthcp = lengthcp;
        this.widthcp = widthcp;
        this.lengthrr = lengthrr;
        this.widthrr = widthrr;
        this.roofmat = roofmat;
        this.woodcladding = woodcladding;
        this.totalPrice = totalPrice;
        this.customerid = customerid;
        this.adminid = adminid;
    }

    public int getRequestid() {
        return requestid;
    }

    public int getLengthcp() {
        return lengthcp;
    }

    public int getWidthcp() {
        return widthcp;
    }

    public int getLengthrr() {
        return lengthrr;
    }

    public int getWidthrr() {
        return widthrr;
    }

    public String getRoofmat() {
        return roofmat;
    }

    public String getWoodcladding() {
        return woodcladding;
    }

    public int getCustomerid() {
        return customerid;
    }

    public int getAdminid() {
        return adminid;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setRequestid(int requestid) {
        this.requestid = requestid;
    }

    public void setLengthcp(int lengthcp) {
        this.lengthcp = lengthcp;
    }

    public void setWidthcp(int widthcp) {
        this.widthcp = widthcp;
    }

    public void setLengthrr(int lengthrr) {
        this.lengthrr = lengthrr;
    }

    public void setWidthrr(int widthrr) {
        this.widthrr = widthrr;
    }

    public void setRoofmat(String roofmat) {
        this.roofmat = roofmat;
    }

    public void setWoodcladding(String woodcladding) {
        this.woodcladding = woodcladding;
    }

    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }

    public void setAdminid(int adminid) {
        this.adminid = adminid;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Request{" +
                "requestid=" + requestid +
                ", lengthcp=" + lengthcp +
                ", widthcp=" + widthcp +
                ", lengthrr=" + lengthrr +
                ", widthrr=" + widthrr +
                ", roofmat='" + roofmat + '\'' +
                ", woodcladding='" + woodcladding + '\'' +
                ", totalPrice='" + totalPrice + '\'' +
                ", customerid=" + customerid +
                ", adminid=" + adminid +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Request request = (Request) o;
        return getRequestid() == request.getRequestid() &&
                getLengthcp() == request.getLengthcp() &&
                getWidthcp() == request.getWidthcp() &&
                getLengthrr() == request.getLengthrr() &&
                getWidthrr() == request.getWidthrr() &&
                Double.compare(request.getTotalPrice(), getTotalPrice()) == 0 &&
                getCustomerid() == request.getCustomerid() &&
                getAdminid() == request.getAdminid() &&
                Objects.equals(getRoofmat(), request.getRoofmat()) &&
                Objects.equals(getWoodcladding(), request.getWoodcladding());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRequestid(), getLengthcp(), getWidthcp(),
                getLengthrr(), getWidthrr(), getRoofmat(), getWoodcladding(),
                getTotalPrice(), getCustomerid(), getAdminid());
    }
}
