------ HƯỚNG DẪN CÀI ĐẶT và CẤU HÌNH------
1. STS - Spring Tool Suite - (phát triển trên Eclipse, và tích hợp các tool dành cho Spring) - sau này dùng để chạy Run as Spring Boot App
https://spring.io/tools3/sts/all

2. Neo4j Desktop
https://neo4j.com/download/

3. Git
https://github.com/dinhhoangnam998/aaa/commits/master

4. Import Project 
 - mở STS 
 - File -> Import -> Existing Maven Project
 - Chờ một chút để Maven tải các thư viện về

5. Tạo database
 - Bật Neo4j Desktop và tạo 1 db rỗng với password là "password"
 - Cổng HTTP port trong phần Manage --> copy vào phần cấu hình của project (nếu mặc định là 7474 rồi thì k cần thực hiện cấu hình lại nữa)

6. Run lombok (- dùng để tự động sinh getter, setter, constuctor, - chỉ cần cấu hình 1 lần)
 - từ Package Explorer -> Maven Dependencies -> lombok-1.18.14.jar -> chuột phải -> run as -> java application
 - từ cửa sổ app mới hiện ra, chọn "Specify location..." và dẫn tới thư mục chương trình STS.exe (hoặc chờ 1, 2p để app tự tìm kiếm)
 - Nhấn Install/Update

7. chuột phải vào project -> chọn Run as -> Spring Boot App
 - chờ một chút....


------	 HƯỚNG DẪN MỘT CHÚT VỀ HỆ THỐNG -------

Hệ thống được chia là làm 4 gói chính: (+2 file)
# 4 Gói:
- <model> -- mô hình hóa dữ liệu, gồm 2 gói nhỏ:
 + entity: là các thực thể
 + relation: là các quan hệ

- <generator> -- đảm bảo nhiệm vụ sinh ngẫu nhiên dữ liệu, cũng gồm 2 gói nhỏ tương tự

- <repository>  -- thực hiện mọi truy vấn, bất kể truy vấn gì, thằng này cực khỏe, cái hay là mình không cần viết Cypher query, 

<service> -- các dịch vụ cung cấp cho người dùng
 + InitDb --> có nhiệm vụ lấy dữ liệu từ người dùng vào khởi tạo db theo yêu cầu
 + QueryService: chứa các hàm truy vấn, cho người dùng lựa chọn và trả về kết quả

 + ....

# 2 file:
+ OopProAppEntry --> tương tự file main, đây là nơi chạy chương trình của mình
+ OopProApplication  --> file của Spring Boot, dùng để cấu hình hệ thống...


