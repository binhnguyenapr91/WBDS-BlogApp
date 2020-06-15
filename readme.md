#### [Bài tập] Tạo ứng dụng Blog
###### Mục tiêu
Luyện tập lưu trữ dữ liệu sử dụng Spring Data JPA và Hibernate.

###### Điều kiện  
Có kiến thức căn bản về việc sử dụng Spring Data JPA và Hibernate.

###### Mô tả  
Trong phần này chúng ta sẽ phát triển một ứng dụng viết blog cá nhân.

###### Version1 - branch master: 

Ứng dụng có các chức năng sau:

-[x] Viết một bài blog mới  
-[x] Hiển thị danh sách tóm tắt các blog  
-[x] Cập nhật nội dung một blog  
-[x] Xem nội dung một blog  
-[x] Xoá một blog  

###### Version2 - branch spring-data-repository:
-[x] Quản lý Danh mục (Category)  
-[x] Hiển thị các bài viết theo từng danh mục  
-[x] Hiển thị tên của Category khi xem một bài viết  

###### Version3 - branch paging-sorting-seaching:
-[x] Phân trang các bài viết  
-[x] Sắp xếp các bài viết theo thời gian được tạo  
-[x] Tìm kiếm bài viết  

###### Version 4 - branch RESTful-API
-[x] Xem danh sách các category  
-[x] Xem danh sách các bài viết  
-[x] Xem danh sách các bài viết của một category  
-[x] Xem chi tiết một bài viết  
  
###### Version 5 - branch ajax
Trong phần này, chúng sẽ tính hợp AJAX vào trong ứng dụng Blog thông qua 2 tính năng
mới:  
-[x] Tìm kiếm: Người dùng nhập từ vào ô tìm kiếm, ứng dụng sẽ gửi request thông qua AJAX để
hiển thị danh sách các bài viết phù hợp  
-[x] Tải thêm: Là tính năng thay thế cho tính năng phân trang. Khi hiển thị danh sách bài viết, chỉ
hiện thị 20 bài viết, sau đó, người dùng sẽ nhấn nút “Tải thêm” để xem các bài viết cũ hơn.    
  
###### Version 6 - branch i18n
 
###### Kiến thức sử dụng:

- Spring Data JPA / Repository  
- Hibernate  
- Thymeleaf  
- Repository Design Pattern 
- RESTful API 
- AJAX
- JQuery

###### Công cụ sử dụng:  

- IDE: IntelliJ  
- DBMS: MySQL  
- WebServer: Apache Tomcat  
- Build tool: Gradle  

###### Khó khăn

-[ ] Xử lý ngày tháng  
-[x] Format dữ liệu nhiều bảng  
-[ ] Sắp xếp bài viết theo ngày


