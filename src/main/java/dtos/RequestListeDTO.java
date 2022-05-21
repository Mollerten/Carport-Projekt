package dtos;

public class RequestListeDTO
{
    int request_id;
    int length_cp;
    int width_cp;
    int length_rr;
    int width_rr;
    String roof_mat;
    String wood_cladding_mat;
    int customer_id;
    int admin_id;



    @Override
    public String toString()
    {
        return "RequestListeDTO{" +
                "request_id=" + request_id +
                ", length_cp=" + length_cp +
                ", width_cp=" + width_cp +
                ", length_rr=" + length_rr +
                ", width_rr=" + width_rr +
                ", roof_mat='" + roof_mat + '\'' +
                ", wood_cladding_mat='" + wood_cladding_mat + '\'' +
                ", customer_id=" + customer_id +
                ", admin_id=" + admin_id +
                '}';
    }

    public int getRequest_id()
    {
        return request_id;
    }

    public void setRequest_id(int request_id)
    {
        this.request_id = request_id;
    }

    public int getLength_cp()
    {
        return length_cp;
    }

    public void setLength_cp(int length_cp)
    {
        this.length_cp = length_cp;
    }

    public int getWidth_cp()
    {
        return width_cp;
    }

    public void setWidth_cp(int width_cp)
    {
        this.width_cp = width_cp;
    }

    public int getLength_rr()
    {
        return length_rr;
    }

    public void setLength_rr(int length_rr)
    {
        this.length_rr = length_rr;
    }

    public int getWidth_rr()
    {
        return width_rr;
    }

    public void setWidth_rr(int width_rr)
    {
        this.width_rr = width_rr;
    }

    public String getRoof_mat()
    {
        return roof_mat;
    }

    public void setRoof_mat(String roof_mat)
    {
        this.roof_mat = roof_mat;
    }

    public String getWood_cladding_mat()
    {
        return wood_cladding_mat;
    }

    public void setWood_cladding_mat(String wood_cladding_mat)
    {
        this.wood_cladding_mat = wood_cladding_mat;
    }

    public int getCustomer_id()
    {
        return customer_id;
    }

    public void setCustomer_id(int customer_id)
    {
        this.customer_id = customer_id;
    }

    public int getAdmin_id()
    {
        return admin_id;
    }

    public void setAdmin_id(int admin_id)
    {
        this.admin_id = admin_id;
    }

    public RequestListeDTO(int request_id, int length_cp, int width_cp, int length_rr, int width_rr, String roof_mat, String wood_cladding_mat, int customer_id, int admin_id)
    {
        this.request_id = request_id;
        this.length_cp = length_cp;
        this.width_cp = width_cp;
        this.length_rr = length_rr;
        this.width_rr = width_rr;
        this.roof_mat = roof_mat;
        this.wood_cladding_mat = wood_cladding_mat;
        this.customer_id = customer_id;
        this.admin_id = admin_id;
    }
}
