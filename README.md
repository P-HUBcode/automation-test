# 🚀 ĐỒ ÁN MÔN HỌC: KIỂM THỬ TỰ ĐỘNG (SOFTWARE AUTOMATION TESTING)

> **Trường Đại học Văn Lang - Khoa Công nghệ Thông tin**  
> **Học phần:** Kiểm thử tự động (`232_71ITSE41603_0102`) | **Khóa:** K27  
> **Nhóm thực hiện:** **Nhóm 09 (Team 09)**  
> **Sinh viên:** Nguyễn Minh Phú - **MSSV:** `2374802013447`

---

## 📌 Giới Thiệu Đồ Án

Đồ án tập trung vào việc nghiên cứu, xây dựng và thực thi kịch bản kiểm thử tự động toàn diện (**Automation Testing Framework**) cho hệ thống **Phân công giảng dạy (Teaching Assignment System)** của Khoa Công nghệ Thông tin - Trường Đại học Văn Lang, bao gồm phân hệ quản lý và phân hệ Ban Chủ Nhiệm Khoa.

### 🎯 Mục Tiêu Dự Án
- Xây dựng khung kiểm thử tự động mạnh mẽ theo kiến trúc **Page Object Model (POM)**.
- Tự động hóa các luồng nghiệp vụ quan trọng: Đăng nhập, Quản lý tài khoản người dùng, Quản lý ngành/bộ môn, Quản lý học kỳ, Quản lý thời khóa biểu, Tính thù lao giảng dạy, Thống kê và Tích hợp luồng Ban Chủ Nhiệm Khoa.
- Áp dụng kiểm thử hướng dữ liệu (**Data-Driven Testing**) và kiểm thử liên kết tích hợp (**Integration Testing**).
- Tạo báo cáo kiểm thử tự động chuyên nghiệp và theo dõi kết quả thực thi.

---

## 📂 Cấu Trúc Dự Án (Project Structure)

```text
automation-test/
├── Do an nhom/                                # Toàn bộ tài nguyên Đồ án môn học
│   ├── 01_TaiLieuThamKhao_References/         # Tài liệu đặc tả hệ thống, backlog & hướng dẫn sử dụng
│   ├── 02_KeHoach_ProjectPlan/                # Kế hoạch thực hiện đồ án (Test Plan Word & Excel)
│   ├── 03_KichBan_TestCases/                  # Bộ kịch bản kiểm thử chi tiết (Test Cases Excel)
│   ├── 04_MaNguon_AutomationProject/          # Mã nguồn Selenium Java Maven theo chuẩn POM
│   │   └── 232_71ITSE41603_Team09_Automation/ # Framework kiểm thử tự động hoàn chỉnh của Team 09
│   ├── 05_BaoCao_WordReports/                 # Báo cáo đồ án chính thức (Team09_Ver1.4.docx)
│   ├── 06_GoiNopBai_Submissions/              # Gói nộp bài hoàn chỉnh (Team09)
│   ├── 07_CongCu_Scripts/                     # Script hỗ trợ sinh tài liệu và tự động hóa
│   ├── 08_LuuTru_Backup/                      # Lưu trữ lịch sử các phiên bản
│   └── ui_images/                             # Toàn bộ hình ảnh thực nghiệm kiểm thử thực tế trên Cốc Cốc / Chrome
│
├── Team09_Ver1.4.docx                         # Báo cáo đồ án học thuật bản chính thức (Ver 1.4)
├── TestCase_DoAnNhom_Team09.xlsx              # Bộ kịch bản kiểm thử đồ án nhóm tổng hợp
├── TestCase_DoAnNhom_Team09_FullSheets.xlsx   # Kịch bản kiểm thử đầy đủ các sheet chức năng
├── KeHoach_DoAnNhom_Team09.xlsx               # Bảng phân công và kế hoạch thực hiện đồ án
├── 232_71ITSE41603_0102_NguyenMinhPhu_Team09.zip # Gói nộp bài Master nén đầy đủ cho giảng viên
├── .gitignore                                 # Bộ lọc bỏ file rác, file nhị phân và cache
└── README.md                                  # Hướng dẫn chi tiết về dự án
```

---

## 🛠️ Công Nghệ & Kỹ Thuật Áp Dụng

- **Ngôn ngữ:** Java (JDK 17+)
- **Testing Framework:** TestNG (Suites, Assertions, DataProvider)
- **Browser Automation:** Selenium WebDriver 4.x (Chrome / Cốc Cốc)
- **Kiến trúc mã nguồn:** Page Object Model (POM) tách biệt Pages và Test Scripts
- **Quản lý dự án & Thư viện:** Apache Maven
- **Báo cáo kiểm thử:** ExtentReports, TestNG Reports, Microsoft Word, Microsoft Excel
- **Kiểm thử tích hợp:** End-to-End Integration Testing giữa các vai trò người dùng

---

## 🏃 Hướng Dẫn Thực Thi Kiểm Thử

### 1. Chuẩn bị môi trường
- Cài đặt Java Development Kit (JDK 17 trở lên) và cấu hình biến môi trường `JAVA_HOME`.
- Cài đặt Apache Maven (3.8+) và cấu hình `PATH`.
- Trình duyệt Chrome hoặc Cốc Cốc phiên bản mới nhất.

### 2. Thực thi kịch bản kiểm thử
Di chuyển vào thư mục mã nguồn Selenium của Team 09:
```bash
cd "Do an nhom/04_MaNguon_AutomationProject/232_71ITSE41603_Team09_Automation"
```

Chạy toàn bộ Test Suites:
```bash
mvn clean test
```

Chạy từng Test Suite / Test Class cụ thể:
```bash
# Chạy kiểm thử chức năng Đăng nhập
mvn test -Dtest=LoginTest

# Chạy kiểm thử tích hợp Ban Chủ Nhiệm Khoa
mvn test -Dtest=FacultyBoardIntegrationTest
```

---

## 👨‍💻 Tác Giả & Bản Quyền

- **Sinh viên:** Nguyễn Minh Phú - MSSV: `2374802013447`
- **Email:** phu47008@gmail.com
- **Lớp:** `232_71ITSE41603_0102` - Khóa K27
- **Khoa Công nghệ Thông tin - Trường Đại học Văn Lang**
