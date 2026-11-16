# 🚀 HỌC PHẦN: KIỂM THỬ TỰ ĐỘNG (SOFTWARE AUTOMATION TESTING)

> **Trường Đại học Văn Lang - Khoa Công nghệ Thông tin**  
> **Lớp:** `232_71ITSE41603_0102` | **Khóa:** K27  
> **Nhóm thực hiện:** **Nhóm 09 (Team 09)**  
> **Sinh viên:** Nguyễn Minh Phú - **MSSV:** `2374802013447`

---

## 📌 Giới Thiệu Dự Án

Kho lưu trữ (**Repository**) này chứa toàn bộ tài nguyên, mã nguồn kiểm thử tự động, kịch bản kiểm thử (Test Cases), kế hoạch kiểm thử (Test Plan) và các báo cáo học thuật thuộc học phần **Kiểm thử tự động**.

Dự án bao gồm:
1. **Đồ án nhóm (Group Project)**: Kiểm thử tự động Web Application (Hệ thống phân công giảng dạy) sử dụng **Selenium WebDriver Java**, mô hình **Page Object Model (POM)**, **TestNG**, và **Data-Driven Testing**.
2. **Bài thực hành Tuần 08 (Lab 08)**: Kiểm thử hướng dữ liệu nâng cao (Data-Driven Testing) với TestNG, Apache POI (Excel) và JSON trên ứng dụng Web.
3. **Bài thực hành Tuần 09 (Lab 09)**: Kiểm thử tự động API (API Testing) với **Postman**, viết Test Scripts, Assertions, quản lý Variables và Data-Driven Testing với Collection Runner (JSON/CSV).

---

## 📂 Cấu Trúc Kho Lưu Trữ (Repository Structure)

```text
automation-test/
├── Do an nhom/                                # Toàn bộ tài liệu và mã nguồn Đồ án nhóm (Team 09)
│   ├── 01_TaiLieuThamKhao_References/         # Tài liệu đặc tả yêu cầu, hướng dẫn sử dụng hệ thống
│   ├── 02_KeHoach_ProjectPlan/                # Kế hoạch kiểm thử chi tiết (Word & Excel)
│   ├── 03_KichBan_TestCases/                  # Bộ kịch bản kiểm thử tổng hợp (Excel Full Sheets)
│   ├── 04_MaNguon_AutomationProject/          # Mã nguồn Selenium Java Maven theo chuẩn POM
│   │   └── 232_71ITSE41603_Team09_Automation/ # Project Selenium WebDriver TestNG
│   ├── 05_BaoCao_WordReports/                 # Báo cáo đồ án hoàn chỉnh (Ver 1.4)
│   ├── 06_GoiNopBai_Submissions/              # Các gói nộp bài chuẩn bị cho giảng viên
│   └── ui_images/                             # Ảnh chụp màn hình kiểm thử thực tế
│
├── Bài thực hành 8-20261106/                 # Bài thực hành Tuần 08: Data-Driven Testing
│   ├── src/                                   # Mã nguồn Java TestNG & Apache POI
│   ├── BaoCao_ThucHanh8_NguyenMinhPhu.docx    # Báo cáo thực hành chi tiết
│   └── pom.xml                                # Cấu hình Maven Dependencies
│
├── Bài thực hành 9-20261113/                 # Bài thực hành Tuần 09: API Testing with Postman
│   ├── Tuan09_API_Testing_NguyenMinhPhu.postman_collection.json # 14 API Requests với assertions
│   ├── Tuan09_Environment.postman_environment.json              # Biến môi trường Postman
│   ├── data_globals.json & data_globals.csv   # Bộ dữ liệu Data-Driven cho Collection Runner
│   ├── Variable_Id.csv                        # Danh sách Id bài viết cho kiểm thử tham số hóa
│   ├── run_tests_api.py & run_api_tests.bat   # Script tự động thực thi 40/40 tests API (100% Pass)
│   ├── BaoCao_ThucHanh9_APITesting_Postman_NguyenMinhPhu.docx   # Báo cáo học thuật chi tiết
│   └── HUONG_DAN_SU_DUNG.txt                  # Hướng dẫn chi tiết cách chạy & nộp bài
│
├── TestCase_DoAnNhom_Team09.xlsx             # File kịch bản kiểm thử đồ án nhóm tổng hợp
├── KeHoach_DoAnNhom_Team09.xlsx              # Kế hoạch thực hiện đồ án nhóm
├── Team09_Ver1.4.docx                        # Báo cáo đồ án nhóm bản chính thức Ver 1.4
├── .gitignore                                 # Bộ lọc bỏ các tệp rác và thư mục build
└── README.md                                  # Hướng dẫn và thông tin dự án
```

---

## 🛠️ Công Nghệ & Công Cụ Sử Dụng

- **Ngôn ngữ lập trình:** Java (JDK 17 / 21), Python 3.13
- **Kiểm thử Web UI:** Selenium WebDriver (4.x), TestNG, Page Object Model (POM)
- **Kiểm thử API:** Postman Desktop, Postman Collection Runner, Python `urllib` Automation Runner
- **Quản lý dự án & Build Tool:** Apache Maven
- **Xử lý dữ liệu kiểm thử (Data-Driven):** Apache POI (Excel `.xlsx`), `org.json` (JSON), CSV
- **Báo cáo & Ghi log:** ExtentReports / TestNG Reports, Microsoft Word, Microsoft Excel

---

## 🏃 Hướng Dẫn Cài Đặt & Thực Thi

### 1. Chạy Kiểm Thử Tự Động Web (Selenium Java)
Yêu cầu: Máy tính đã cài đặt JDK (17+) và Apache Maven.
```bash
# Di chuyển vào thư mục dự án Selenium của Nhóm 9
cd "Do an nhom/04_MaNguon_AutomationProject/232_71ITSE41603_Team09_Automation"

# Biên dịch và chạy toàn bộ Test Suites
mvn clean test
```

### 2. Chạy Kiểm Thử API Postman
- **Cách 1: Sử dụng Postman Desktop**
  1. Mở Postman -> Chọn **Import** -> Kéo thả `Tuan09_API_Testing_NguyenMinhPhu.postman_collection.json` và `Tuan09_Environment.postman_environment.json`.
  2. Chọn Environment: `Tuan09_Environment`.
  3. Mở **Collection Runner** -> Chọn `data_globals.json` hoặc `data_globals.csv` -> Nhấn **Run**.
- **Cách 2: Chạy 1-Click tự động không cần Postman**
  - Nhấp đúp chuột vào file `Bài thực hành 9-20261113/run_api_tests.bat`.
  - Hoặc chạy qua dòng lệnh:
    ```bash
    python "Bài thực hành 9-20261113/run_tests_api.py"
    ```
  - Kết quả kiểm thử: **40/40 tests PASSED (100%)**.

---

## 👨‍💻 Tác Giả & Bản Quyền

- **Sinh viên:** Nguyễn Minh Phú - MSSV: `2374802013447`
- **Email:** phu47008@gmail.com
- **GitHub:** [@P-HUBcode](https://github.com/P-HUBcode)
- **Khoa Công nghệ Thông tin - Trường Đại học Văn Lang**
