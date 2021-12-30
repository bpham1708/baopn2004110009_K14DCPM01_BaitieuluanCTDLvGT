package com.baopn2004110009.BaitieuluanCTDL;

public class TTHH 
{
    private static int count = 0;
    int ID_san_pham;
    String Loai_hang;
    String Ten_hang_hoa;
    int Gia_nhap_kho;
    int So_luong_ton_kho;
    String Ngay_nhap_kho;
    public TTHH(String Loai_hang, String Ten_hang_hoa, int Gia_nhap_kho, int So_luong_ton_kho, String Ngay_nhap_kho) {
        super();
        this.Loai_hang = Loai_hang;
        this.Ten_hang_hoa = Ten_hang_hoa;
        this.Gia_nhap_kho = Gia_nhap_kho;
        this.So_luong_ton_kho = So_luong_ton_kho;
        this.Ngay_nhap_kho = Ngay_nhap_kho;
        this.ID_san_pham = ++count;
    }
    public String getLoai_hang() 
    {
        return Loai_hang;
    }
    public void setLoai_Hang(String Loai_hang) 
    {
        this.Loai_hang = Loai_hang;
    }
    public String getTen_hang_hoa() 
    {
        return Ten_hang_hoa;
    }
    public void setTen_hang_hoa(String Ten_hang_hoa) 
    {
        this.Ten_hang_hoa = Ten_hang_hoa;
    }
    public int getGia_nhap_kho() 
    {
        return Gia_nhap_kho;
    }
    public void setGia_nhap_kho(int Gia_nhap_kho)
    {
        this.Gia_nhap_kho = Gia_nhap_kho;
    }
    public int getSo_luong_ton_kho() 
    {
        return So_luong_ton_kho;
    }
    public void setSo_luong_ton_kho(int So_luong_ton_kho) 
    {
        this.So_luong_ton_kho = So_luong_ton_kho;
    }
    public String getNgay_nhap_kho() 
    {
        return Ngay_nhap_kho;
    }
    public void setNgay_nhap_kho(String Ngay_nhap_kho) 
    {
        this.Ngay_nhap_kho = Ngay_nhap_kho;
    }    
}
