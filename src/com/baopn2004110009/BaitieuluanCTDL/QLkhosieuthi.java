package com.baopn2004110009.BaitieuluanCTDL;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class QLkhosieuthi 
{
    public static void main(String[] args) throws ParseException 
    {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		ArrayList<TTHH> Danh_sach_hang_hoa = new ArrayList<TTHH>();
		AddRecord(Danh_sach_hang_hoa);
		int choice;
		while (true) 
        {
			Menu();
			choice = IntInput("lựa chọn của bạn");
			if (choice == 1) 
            {
				System.out.println("Các loại hàng hoá");
				String Loai_hang;
				while (true) {
					System.out.println("1= Thực phẩm");
					System.out.println("2= Sành sứ");
					System.out.println("3= Điện máy");
					int Loai_hang_choice = IntInput("Vui lòng nhập loại hàng hoá:");
					if (Loai_hang_choice == 1) 
                    {
						Loai_hang = "Thực phẩm";
						break;
					} 
                    else if (Loai_hang_choice == 2) 
                    {
						Loai_hang = "Sành sứ";
						break;
					} 
                    else if (Loai_hang_choice == 3) 
                    {
						Loai_hang = "Điện máy";
						break;
					} 
                    else {
						System.out.println("Bạn đã nhập sai loại hàng hoá!!!");
						continue;
					}
				}
			String Ten_hang_hoa = StringInput("Tên hàng hoá");
			int Gia_nhap_kho = IntInput("Giá nhập kho");
			int So_luong_ton_kho = IntInput("Số lượng tồn kho");
			String Ngay_nhap_kho = DateInput("ngày nhập");
			TTHH new_1 = new TTHH(Loai_hang,Ten_hang_hoa,Gia_nhap_kho,So_luong_ton_kho,Ngay_nhap_kho);
			Danh_sach_hang_hoa.add(new_1);
			System.out.println("Đã thêm hàng hóa thành công!!!");
			}
			else if(choice == 2) 
            {
				System.out.println("------------------Chỉnh sửa thông tin hàng hoá------------------");
				int ID = IntInput(" ID sản phẩm");
				for (TTHH i : Danh_sach_hang_hoa) {
					if (i.ID_san_pham == ID) {
						XuatThongTinHang(i);
						System.out.println("Nhập loại hàng hoá mới");
						String new_Loai_hang;
						while (true) {
							System.out.println("1= Thực phẩm");
							System.out.println("2= Sành sứ");
							System.out.println("3= Điện máy");
							int Loai_hang_choice = IntInput("Vui lòng nhập loại hàng:");
							if (Loai_hang_choice == 1) 
                            {
								new_Loai_hang = "Thực phẩm";
								break;
							} 
                            else if (Loai_hang_choice == 2) 
                            {
								new_Loai_hang = "Sành sứ";
								break;
							} 
                            else if (Loai_hang_choice == 3) 
                            {
								new_Loai_hang = "Điện máy";
								break;
							} 
                            else {
								System.out.println("Bạn đã nhập sai loại hàng hoá");
								continue;
							}
						}
						String new_Ten_hang_hoa = StringInput("Nhập tên hàng hoá mới: ");
						int new_Gia_nhap_kho = IntInput("Nhập giá hàng hoá: ");
						int new_So_luong_ton_kho = IntInput("Nhập số lượng: ");
						String new_Ngay_nhap_kho = DateInput("Nhập ngày nhập kho: ");
						i.setTen_hang_hoa(new_Ten_hang_hoa);
						i.setLoai_Hang(new_Loai_hang);
						i.setSo_luong_ton_kho(new_So_luong_ton_kho);
						i.setGia_nhap_kho(new_Gia_nhap_kho);
						i.setNgay_nhap_kho(new_Ngay_nhap_kho);
						System.out.println("Sửa thông tin hàng hóa thành công!!!");
						break;
					} 
                    else if(Danh_sach_hang_hoa.indexOf(i) < Danh_sach_hang_hoa.size()) 
                    {
						continue;
					} 
                    else 
                    {
						System.out.println("Không tìm thấy hàng hóa!!!");
					}
				}
			}
			else if(choice == 3) 
            {
				System.out.println("------------------Xóa thông tin hàng hoá------------------");
				int ID = IntInput("ID sản phẩm");
				int index;
				for (TTHH i : Danh_sach_hang_hoa) 
                {
					if (i.ID_san_pham == ID) 
                    {
						index = Danh_sach_hang_hoa.indexOf(i);
						Danh_sach_hang_hoa.remove(index);
						System.out.println("Đã xoá hàng hoá thành công!!!");
						break;
					}
				}			
			}
			else if(choice == 4) 
            {
				while (true) {
					System.out.println("------------------Tìm kiếm thông tin hàng hoá------------------");
					System.out.println("1. Tìm kiếm theo loại hàng hoá");
					System.out.println("2. Tìm kiếm theo giá hàng hoá");
					System.out.println("3. Tìm kiếm theo ngày nhập kho");
					System.out.println("4. Return to main menu");
					int search_choice = IntInput("Lựa chọn");
					
					if (search_choice == 1) 
                    {
						System.out.println("Nhập loại hàng hoá cần tìm");
						String search_Loai_hang;
						while (true) 
                        {
							System.out.println("1: Thực phẩm");
							System.out.println("2: Sành sứ");
							System.out.println("3: Điện máy");
							int Loai_hang_choice = IntInput("Vui lòng nhập loại hàng hoá: ");
							if (Loai_hang_choice == 1) 
                            {
								search_Loai_hang = "Thực phẩm";
								break;
							} 
                            else if (Loai_hang_choice == 2) 
                            {
								search_Loai_hang = "Sành sứ";
								break;
							} 
                            else if (Loai_hang_choice == 3) 
                            {
								search_Loai_hang = "Điện máy";
								break;
							} 
                            else 
                            {
								System.out.println("Bạn đã nhập sai loại hàng hoá!!!");
								continue;
							}
						}
						for (TTHH i : Danh_sach_hang_hoa) 
                        {
							if (i.Loai_hang == search_Loai_hang) 
                            {
								XuatThongTinHang(i);
							}
						}
					} 
                    else if(search_choice == 2) 
                    {
						int min_Gia_nhap_kho = IntInput("Giá hàng hoá thấp nhất");
						int max_Gia_nhap_kho = IntInput("Giá hàng hoá cao nhất");
						for (TTHH i : Danh_sach_hang_hoa) 
                        {
							if (min_Gia_nhap_kho <= i.Gia_nhap_kho && i.Gia_nhap_kho <= max_Gia_nhap_kho ) {
								XuatThongTinHang(i);
							}
						}
					} 
                    else if(search_choice == 3) 
                    {
						String start_Ngay_nhap_kho = DateInput("Ngày bắt đầu");
						String end_Ngay_nhap_kho = DateInput("Ngày kết thúc");
						Date Ngay_nhap_kho1 = sdf.parse(start_Ngay_nhap_kho);
						Date Ngay_nhap_kho2 = sdf.parse(end_Ngay_nhap_kho);
						for (TTHH i : Danh_sach_hang_hoa) 
                        {
							Date Ngay_nhap_kho = sdf.parse(i.Ngay_nhap_kho);
							if (Ngay_nhap_kho1.before(Ngay_nhap_kho)==true && Ngay_nhap_kho2.after(Ngay_nhap_kho)==true){
								XuatThongTinHang(i);
							} 
                            else if(Ngay_nhap_kho1.equals(Ngay_nhap_kho)==true || Ngay_nhap_kho2.equals(Ngay_nhap_kho)) 
                            {
								XuatThongTinHang(i);
							}
						}
					} else if(search_choice == 4) 
                    {
						break;
					} 
                    else 
                    {
						continue;
					}
				}
			}
			else if(choice == 5) 
            {
				System.out.println("------------------Sắp xếp thông tin hàng hóa------------------");
				ArrayList<TTHH> Danh_sach_thuc_pham = new ArrayList<TTHH>();
				ArrayList<TTHH> Danh_sach_sanh_su = new ArrayList<TTHH>();
				ArrayList<TTHH> Danh_sach_dien_may = new ArrayList<TTHH>();
				for (TTHH i : Danh_sach_hang_hoa) 
                {
					if (i.Loai_hang == "Thực phẩm") 
                    {
						Danh_sach_thuc_pham.add(i);
					} 
                    else if(i.Loai_hang == "Sành sứ") 
                    {
						Danh_sach_sanh_su.add(i);
					} 
                    else 
                    {
						Danh_sach_dien_may.add(i);
					}
				}
				TTHH [] Danh_sach_thuc_pham2 = Danh_sach_thuc_pham.toArray(new TTHH[Danh_sach_thuc_pham.size()]);
				TTHH [] Danh_sach_sanh_su2 = Danh_sach_sanh_su.toArray(new TTHH[Danh_sach_sanh_su.size()]);
				TTHH [] Danh_sach_dien_may2 = Danh_sach_dien_may.toArray(new TTHH[Danh_sach_dien_may.size()]);
				while (true) 
                {
					System.out.println("1. Sắp xếp theo giá tăng dần");
					System.out.println("2. Sắp xếp theo giá giảm dần");
					System.out.println("3. Sắp xếp theo ngày tăng dần");
					System.out.println("4. Sắp xếp theo ngày giảm dần");
					System.out.println("5. Return to main menu");
					int sort_choice = IntInput("Các loại sắp xếp");
					if (sort_choice == 1) 
                    {
						SapXepGiaTang(Danh_sach_thuc_pham);
						SapXepGiaTang(Danh_sach_sanh_su);
						SapXepGiaTang(Danh_sach_dien_may);
						System.out.println("-------------------Thực Phẩm-------------------");
						for (TTHH i : Danh_sach_thuc_pham) 
                        {
							XuatThongTinHang(i);
						}
						System.out.println("-------------------Sành Sứ-------------------");
						for (TTHH i : Danh_sach_sanh_su) 
                        {
							XuatThongTinHang(i);
						}
						System.out.println("-------------------Điện Máy-------------------");
						for (TTHH i : Danh_sach_dien_may) 
                        {
							XuatThongTinHang(i);
						}
					} 
                    else if(sort_choice == 2) 
                    {
						SapXepGiaGiam(Danh_sach_thuc_pham);
						SapXepGiaGiam(Danh_sach_sanh_su);
						SapXepGiaGiam(Danh_sach_dien_may);
						System.out.println("-------------------Thực Phẩm-------------------");
						for (TTHH i : Danh_sach_thuc_pham) 
                        {
							XuatThongTinHang(i);
						}
						System.out.println("-------------------Sành Sứ-------------------");
						for (TTHH i : Danh_sach_sanh_su) {
							XuatThongTinHang(i);
						}
						System.out.println("-------------------Điện Máy-------------------");
						for (TTHH i : Danh_sach_dien_may) {
							XuatThongTinHang(i);
						}
					} 
                    else if (sort_choice==3) 
                    {
						SapXepNgayTang(Danh_sach_thuc_pham2);
						SapXepNgayTang(Danh_sach_sanh_su2);
						SapXepNgayTang(Danh_sach_dien_may2);
						System.out.println("-------------------Thực Phẩm-------------------");
						for (int i = 0; i < Danh_sach_thuc_pham2.length; i++) 
                        {
							XuatThongTinHang(Danh_sach_thuc_pham2[i]);
						}
						System.out.println("-------------------Sành Sứ-------------------");
						for (int i = 0; i < Danh_sach_sanh_su2.length; i++) 
                        {
							XuatThongTinHang(Danh_sach_sanh_su2[i]);
						}
						System.out.println("-------------------Điện Máy-------------------");
						for (int i = 0; i < Danh_sach_dien_may2.length; i++) 
                        {
							XuatThongTinHang(Danh_sach_dien_may2[i]);
						}
					} 
                    else if (sort_choice==4) 
                    {
						SapXepNgayGiam(Danh_sach_thuc_pham2);
						SapXepNgayGiam(Danh_sach_sanh_su2);
						SapXepNgayGiam(Danh_sach_dien_may2);
						System.out.println("-------------------Thực Phẩm-------------------");
						for (int i = 0; i < Danh_sach_thuc_pham2.length; i++) 
                        {
							XuatThongTinHang(Danh_sach_thuc_pham2[i]);
						}
						System.out.println("-------------------Sành Sứ-------------------");
						for (int i = 0; i < Danh_sach_sanh_su2.length; i++) 
                        {
							XuatThongTinHang(Danh_sach_sanh_su2[i]);
						}
						System.out.println("-------------------Điện Máy-------------------");
						for (int i = 0; i < Danh_sach_dien_may2.length; i++) 
                        {
							XuatThongTinHang(Danh_sach_dien_may2[i]);
						}
					} 
                    else if(sort_choice == 5) 
                    {
						break;
					} 
                    else 
                    {
						continue;
					}
				}
			}
			else if(choice == 6) 
            {
				System.out.println("------------------Xem lại thống kê------------------");
				int TongSoLuongHangHoa = 0;
				int TongGiaTriNhapHang = 0;
				int SoLuongHangThucPham = 0;
				int SoLuongHangSanhSu = 0;
				int SoLuongHangDienMay = 0;
				for (TTHH i : Danh_sach_hang_hoa) {
					TongSoLuongHangHoa = TongSoLuongHangHoa + i.So_luong_ton_kho;
					int gia_tri = i.So_luong_ton_kho*i.Gia_nhap_kho;
					TongGiaTriNhapHang = TongGiaTriNhapHang + gia_tri;
					if (i.Loai_hang == "Thực phẩm") 
                    {
						SoLuongHangThucPham = SoLuongHangThucPham+i.So_luong_ton_kho;
					} 
                    else if (i.Loai_hang == "Sành sứ") 
                    {
						SoLuongHangSanhSu = SoLuongHangSanhSu+i.So_luong_ton_kho;
					} else 
                    {
						SoLuongHangDienMay = SoLuongHangDienMay+i.So_luong_ton_kho;
					}
				}
				System.out.println("Tổng số lượng hàng hóa: "+Integer.toString(TongSoLuongHangHoa));
				System.out.println("Tổng giá trị nhập kho: "+Integer.toString(TongGiaTriNhapHang));
				System.out.println("Số lượng hàng thực phẩm: "+Integer.toString(SoLuongHangThucPham));
				System.out.println("Số lượng hàng sành sứ: "+Integer.toString(SoLuongHangSanhSu));
				System.out.println("Số lượng hàng điện máy: "+Integer.toString(SoLuongHangDienMay));
				System.out.println("---------------------------------------------------");
			}
			else if(choice == 7) 
            {
				System.out.println("------------------Exit------------------");
			}
			else{
				System.out.println("Bạn đã nhập sai thao tác!!!");
			}	
		}
	}
	static void Menu() {
		System.out.println("-------------------------Quản Lý Hàng Hóa-------------------------");
		System.out.println("1: Thêm thông tin hàng hóa");
		System.out.println("2: Chỉnh sửa thông tin hàng hóa");
		System.out.println("3: Xóa thông tin hàng hóa");
		System.out.println("4: Tìm kiếm thông tin hàng hóa");
		System.out.println("5: Sắp xếp thông tin hàng hóa");
		System.out.println("6: Xem lại thống kê");
		System.out.println("7: Exit");
		System.out.println();
	}
	static void XuatThongTinHang(TTHH a) {
		System.out.println("--------------------------------------");
		System.out.println("Mã hàng: "+a.ID_san_pham);
		System.out.println("Tên hàng: "+a.getTen_hang_hoa());
		System.out.println("Loại hàng: "+a.getLoai_hang());
		System.out.println("Giá: "+a.getGia_nhap_kho()+"đ");
		System.out.println("Số lượng: "+a.getSo_luong_ton_kho());
		System.out.println("Ngày nhập: "+a.getNgay_nhap_kho());
		System.out.println("--------------------------------------");
		System.out.println();
	}
	static int IntInput(String title) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Vui lòng nhập "+title+" : ");
		while(!sc.hasNextInt()) {
			System.out.print("Thao tác sai vui lòng thử lại lại "+title+": ");
			sc.next();
		}
		int value = sc.nextInt();
		return value;
	}
    
	static String StringInput(String title) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Vui lòng nhập "+title+" : ");
		while(!sc.hasNextLine()) {
			System.out.print("Thao tác sai vui lòng thử lại "+title+": ");
			sc.next();
		}
		String value = sc.nextLine();
		return value;
	}
	static String DateInput(String title) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Vui lòng nhập "+title+" : ");
		String dd,mm,yyyy;
		while (true) 
        {
				dd = Integer.toString(IntInput("Ngày"));
				if (dd.length()==2) {
					break;
				} else {
					System.out.println("Thao tác sai vui lòng thử lại!");
					continue;
				}
			}
		
		while (true) 
        {
				mm = Integer.toString(IntInput("Tháng"));
				if (mm.length()==2) {
					break;
				} else {
					System.out.println("Thao tác sai vui lòng thử lại!");
					continue;
				}
			}
		
		while (true) {
				yyyy = Integer.toString(IntInput("Năm"));
				if (yyyy.length()==4) {
					break;
				} else {
					System.out.println("Thao tác sai vui lòng thử lại!");
					continue;
				}
			}
		String result = dd + "/" + mm + "/" + yyyy;
		return result;
	}
	static void AddRecord(ArrayList<TTHH> list) 
    {
		TTHH new_1 = new TTHH("Thực phẩm","Snack Swing",6000,1000,"25-3-2021");
		list.add(new_1);
		TTHH new_2 = new TTHH("Thực phẩm","Cá hộp 3 cô gái",35600,800,"9-6-2021");
		list.add(new_2);
		TTHH new_3 = new TTHH("Thực phẩm","Rau cải",220000,100,"25-12-2021");
		list.add(new_3);
		TTHH new_4 = new TTHH("Thực phẩm","Thịt heo(vai)",68000,100,"31-12-2021");
		list.add(new_4);
		TTHH new_5 = new TTHH("Thực phẩm","Mì tương đen ăn liển",18000,300,"20-10-2021");
		list.add(new_5);
		TTHH new_6 = new TTHH("Thực phẩm","Bánh gạo",36000,500,"22-10-2021");
		list.add(new_6);
		TTHH new_7 = new TTHH("Thực phẩm","Mì Udon",18000,600,"25-10-2021");
		list.add(new_7);
		TTHH new_8 = new TTHH("Sành sứ","Chậu cây",400000,200,"26-10-2021");
		list.add(new_8);
		TTHH new_9 = new TTHH("Sành sứ","Bình cắm hoa",359000,200,"26-10-2021");
		list.add(new_9);
		TTHH new_10 = new TTHH("Sành sứ","Chén",190000,400,"27-10-2021");
		list.add(new_10);
		TTHH new_11 = new TTHH("Sành sứ","Đĩa",240000,400,"28-10-2021");
		list.add(new_11);
		TTHH new_12 = new TTHH("Sành sứ","Gạch men",890000,5000,"30-10-2021");
		list.add(new_12);
		TTHH new_13 = new TTHH("Sành sứ","Nồi sứ",360000,300,"01-11-2021");
		list.add(new_13);
		TTHH new_14 = new TTHH("Điện máy"," Televison Samsung 8K",100000000,10,"02-11-2021");
		list.add(new_14);
		TTHH new_15 = new TTHH("Điện máy","Máy điều hoà không khí",19800000,100,"03-11-2021");
		list.add(new_15);
		TTHH new_16 = new TTHH("Điện máy","Máy lọc nước Kangaroo",6500000,100,"03-11-2021");
		list.add(new_16);
		TTHH new_17 = new TTHH("Điện máy","Máy giăt Samsung",14000000,150,"04-11-2021");
		list.add(new_17);
		TTHH new_18 = new TTHH("Điện máy","Tủ Lạnh Sanyo ",5800000,100,"05-11-2021");
		list.add(new_18);
		TTHH new_19 = new TTHH("Điện máy","Bếp điện từ",6200000,200,"06-11-2021");
		list.add(new_19);
		TTHH new_20 = new TTHH("Điện máy","Loa Sony",2300000,120,"07-11-2021");
		list.add(new_20);
	}
	static void SapXepGiaTang(ArrayList<TTHH> list) 
    {
		Collections.sort(list, new Comparator<TTHH>()
        {
			public int compare(TTHH o1, TTHH o2) {
				return o1.Gia_nhap_kho - o2.Gia_nhap_kho;
			}
		}
        );
	}
	static void SapXepGiaGiam(ArrayList<TTHH> list) 
    {
		Collections.sort(list, new Comparator<TTHH>()
        { 
			public int compare(TTHH o1, TTHH o2) {
				return o2.Gia_nhap_kho - o1.Gia_nhap_kho;
			}
		}
        );
	}
	static void SapXepNgayTang(TTHH [] list) throws ParseException 
    {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		TTHH temp = list[0];
		for (int i = 0; i < list.length -1; i++) 
        {
			for (int j = i + 1; j < list.length; j++) 
            {
				Date Ngay_nhap_kho1 = sdf.parse(list[i].Ngay_nhap_kho);
				Date Ngay_nhap_kho2 = sdf.parse(list[j].Ngay_nhap_kho);
				if (Ngay_nhap_kho1.after(Ngay_nhap_kho2)==true) 
                {
					temp = list[j];
					list[j] = list[i];
					list[i] = temp;
				}
			}
		}
	}
	static void SapXepNgayGiam(TTHH [] list) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		TTHH temp = list[0];
		for (int i = 0; i < list.length -1; i++) {
			for (int j = i + 1; j < list.length; j++) {
				Date Ngay_nhap_kho1 = sdf.parse(list[i].Ngay_nhap_kho);
				Date Ngay_nhap_kho2 = sdf.parse(list[j].Ngay_nhap_kho);
				if (Ngay_nhap_kho1.before(Ngay_nhap_kho2)==true) {
					temp = list[j];
					list[j] = list[i];
					list[i] = temp;
					
				}
			}
		}
    }
}
