<%@page import="models.Bill"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/templates/admin/inc/header.jsp" %>

 <div id="wrapper">
    <%@ include file="/templates/admin/inc/leftbar.jsp" %>
            <!-- Main Content -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

                <!-- Topbar -->
                <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                    <!-- Sidebar Toggle (Topbar) -->
                    <form class="form-inline">
                        <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                            <i class="fa fa-bars"></i>
                        </button>
                    </form>

                    <!-- Topbar Search -->
                    <form
                        class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
                        <div class="input-group">
                            <input type="text" class="form-control bg-light border-0 small" placeholder="Search for..."
                                aria-label="Search" aria-describedby="basic-addon2">
                            <div class="input-group-append">
                                <button class="btn btn-primary" type="button">
                                    <i class="fas fa-search fa-sm"></i>
                                </button>
                            </div>
                        </div>
                    </form>

                    <!-- Topbar Navbar -->
                    <ul class="navbar-nav ml-auto">

                        <!-- Nav Item - Search Dropdown (Visible Only XS) -->
                        <li class="nav-item dropdown no-arrow d-sm-none">
                            <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <i class="fas fa-search fa-fw"></i>
                            </a>
                            <!-- Dropdown - Messages -->
                            <div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in"
                                aria-labelledby="searchDropdown">
                                <form class="form-inline mr-auto w-100 navbar-search">
                                    <div class="input-group">
                                        <input type="text" class="form-control bg-light border-0 small"
                                            placeholder="Search for..." aria-label="Search"
                                            aria-describedby="basic-addon2">
                                        <div class="input-group-append">
                                            <button class="btn btn-primary" type="button">
                                                <i class="fas fa-search fa-sm"></i>
                                            </button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </li>

                        <!-- Nav Item - Alerts -->
                        <li class="nav-item dropdown no-arrow mx-1">
                            <a class="nav-link dropdown-toggle" href="#" id="alertsDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <i class="fas fa-bell fa-fw"></i>
                                <!-- Counter - Alerts -->
                                <span class="badge badge-danger badge-counter">3+</span>
                            </a>
                            <!-- Dropdown - Alerts -->
                            <div class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                aria-labelledby="alertsDropdown">
                                <h6 class="dropdown-header">
                                    Alerts Center
                                </h6>
                                <a class="dropdown-item d-flex align-items-center" href="#">
                                    <div class="mr-3">
                                        <div class="icon-circle bg-primary">
                                            <i class="fas fa-file-alt text-white"></i>
                                        </div>
                                    </div>
                                    <div>
                                        <div class="small text-gray-500">December 12, 2019</div>
                                        <span class="font-weight-bold">A new monthly report is ready to download!</span>
                                    </div>
                                </a>
                                <a class="dropdown-item d-flex align-items-center" href="#">
                                    <div class="mr-3">
                                        <div class="icon-circle bg-success">
                                            <i class="fas fa-donate text-white"></i>
                                        </div>
                                    </div>
                                    <div>
                                        <div class="small text-gray-500">December 7, 2019</div>
                                        $290.29 has been deposited into your account!
                                    </div>
                                </a>
                                <a class="dropdown-item d-flex align-items-center" href="#">
                                    <div class="mr-3">
                                        <div class="icon-circle bg-warning">
                                            <i class="fas fa-exclamation-triangle text-white"></i>
                                        </div>
                                    </div>
                                    <div>
                                        <div class="small text-gray-500">December 2, 2019</div>
                                        Spending Alert: We've noticed unusually high spending for your account.
                                    </div>
                                </a>
                                <a class="dropdown-item text-center small text-gray-500" href="#">Show All Alerts</a>
                            </div>
                        </li>

                        <!-- Nav Item - Messages -->
                        <li class="nav-item dropdown no-arrow mx-1">
                            <a class="nav-link dropdown-toggle" href="#" id="messagesDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <i class="fas fa-envelope fa-fw"></i>
                                <!-- Counter - Messages -->
                                <span class="badge badge-danger badge-counter">7</span>
                            </a>
                            <!-- Dropdown - Messages -->
                            <div class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                aria-labelledby="messagesDropdown">
                                <h6 class="dropdown-header">
                                    Message Center
                                </h6>
                                <a class="dropdown-item d-flex align-items-center" href="#">
                                    <div class="dropdown-list-image mr-3">
                                        <img class="rounded-circle" src="<%=request.getContextPath()%>/templates/admin/img/undraw_profile_1.svg"
                                            alt="">
                                        <div class="status-indicator bg-success"></div>
                                    </div>
                                    <div class="font-weight-bold">
                                        <div class="text-truncate">Hi there! I am wondering if you can help me with a
                                            problem I've been having.</div>
                                        <div class="small text-gray-500">Emily Fowler · 58m</div>
                                    </div>
                                </a>
                                <a class="dropdown-item d-flex align-items-center" href="#">
                                    <div class="dropdown-list-image mr-3">
                                        <img class="rounded-circle" src="<%=request.getContextPath()%>/templates/admin/img/undraw_profile_2.svg"
                                            alt="">
                                        <div class="status-indicator"></div>
                                    </div>
                                    <div>
                                        <div class="text-truncate">I have the photos that you ordered last month, how
                                            would you like them sent to you?</div>
                                        <div class="small text-gray-500">Jae Chun · 1d</div>
                                    </div>
                                </a>
                                <a class="dropdown-item d-flex align-items-center" href="#">
                                    <div class="dropdown-list-image mr-3">
                                        <img class="rounded-circle" src="<%=request.getContextPath()%>/templates/admin/img/undraw_profile_3.svg"
                                            alt="">
                                        <div class="status-indicator bg-warning"></div>
                                    </div>
                                    <div>
                                        <div class="text-truncate">Last month's report looks great, I am very happy with
                                            the progress so far, keep up the good work!</div>
                                        <div class="small text-gray-500">Morgan Alvarez · 2d</div>
                                    </div>
                                </a>
                                <a class="dropdown-item d-flex align-items-center" href="#">
                                    <div class="dropdown-list-image mr-3">
                                        <img class="rounded-circle" src="https://source.unsplash.com/Mv9hjnEUHR4/60x60"
                                            alt="">
                                        <div class="status-indicator bg-success"></div>
                                    </div>
                                    <div>
                                        <div class="text-truncate">Am I a good boy? The reason I ask is because someone
                                            told me that people say this to all dogs, even if they aren't good...</div>
                                        <div class="small text-gray-500">Chicken the Dog · 2w</div>
                                    </div>
                                </a>
                                <a class="dropdown-item text-center small text-gray-500" href="#">Read More Messages</a>
                            </div>
                        </li>

                        <div class="topbar-divider d-none d-sm-block"></div>

                        <!-- Nav Item - User Information -->
                        <li class="nav-item dropdown no-arrow">
                            <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <span class="mr-2 d-none d-lg-inline text-gray-600 small">Xin chào, <%=staff.getStaff_name()%></span>
                                <img class="img-profile rounded-circle"
                                    src="<%=request.getContextPath()%>/templates/admin/img/<%=staff.getStaff_image()%>">
                            </a>
                            <!-- Dropdown - User Information -->
                            <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                aria-labelledby="userDropdown">
                                <a class="dropdown-item" href="#">
                                    <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Thông tin tài khoàn
                                </a>
                                <a class="dropdown-item" href="#">
                                    <i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Cài đặt
                                </a>
                                <a class="dropdown-item" href="#">
                                    <i class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Thời gian hoạt động
                                </a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="<%=request.getContextPath()%>/adminlogout" onclick="return confirm('Bạn có muốn đăng xuất không ?')">
                                    <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Đăng xuất
                                </a>
                            </div>
                        </li>

                    </ul>

                </nav>
                <!-- End of Topbar -->

                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">Quản lý hóa đơn</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>Mã hóa đơn</th>
                                            <th>Mã sản phẩm</th>
                                            <th>Ảnh sản phẩm</th>
                                            <th>Tên sản phẩm</th>
                                            <th>Số lượng</th>
                                            <th>Đơn giá ($)</th>
                                            <th>Khuyến mãi (%)</th>
                                            <th>Tổng tiền ($)</th>
                                            <th>Tên khách hàng</th>
                                            <th>Mã khách hàng</th>
                                            <th>Ngày mua</th>
                                            <th>Trạng thái</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <%
                                    	ArrayList<Bill> listBill = null;
                                    	if(staff.getPer_name().equals("Administrator")){
	                                    	if(request.getAttribute("listBill") != null){
	                                    		listBill = (ArrayList<Bill>)request.getAttribute("listBill");
	                                    		for(Bill bill : listBill){
									%>
                                        <tr>
                                            <td><%=bill.getBill_id()%></td>
                                            <td><%=bill.getBill_product_id()%></td>
                                            <td><img src="<%=request.getContextPath()%>/templates/public/images/<%=bill.getBill_product_image()%>" style="width: 250px;height: auto" /></td>
                                            <td><%=bill.getBill_product_name()%></td>
                                            <td><%=bill.getBill_product_amount()%></td>
                                            <td><%=bill.getBill_product_price()%></td>
                                            <td><%=bill.getBill_product_promotion()%></td>
                                            <td><%=bill.getBill_product_money()%></td>
                                            <td><%=bill.getUser_fullname()%></td>
                                            <td><%=bill.getUser_id()%></td>
                                            <td><%=bill.getDate()%></td>
                                            <%
                                            	if(bill.getStatus() == 1){
                                            %>
                                            <td><h6 style="color: red;font-weight: bold;">Ship thành công</h6></td>
                                            <%}else{ %>
                                             <td id="change"><input id="check<%=bill.getBill_id()%>" type="checkbox" onclick="checkBill(<%=bill.getBill_id()%>)" data-toggle="toggle" data-onstyle="success" data-offstyle="danger"></td>
                                            <%} %>
                                        </tr>
                                     <%
                                    		}
                                    	}
	                                %>
	                                </tbody>
                                </table>
                            </div>
                        </div>
                    </div>

                </div>
                <!-- /.container-fluid -->
                 <div class="container">
                             <%
                           		int numberOfPages=(Integer)request.getAttribute("numberOfPages");
                           		int currentPage=(Integer)request.getAttribute("currentPage");
                           		if(listBill != null && listBill.size() > 0 && numberOfPages > 1){	
                            %>
                 	<h5 style="float: left;color: #4E73DF;font-weight: bold;">Trang <%=currentPage%> của <%=numberOfPages%></h5>
                    <div class="row" style="float: right;padding-bottom: 25px;">
                    <%
    					if (currentPage > 1) {
     						int back = currentPage - 1;
    				%>
                        <a href="<%=request.getContextPath()%>/adminbill?page=<%=back%>">Trước</a>&nbsp;
                    <%
                          }
                    %>
                    <%
                        for(int i=1;i<=numberOfPages;i++){
                            if(currentPage==i){
                    %>
                        <a href="<%=request.getContextPath()%>/adminbill?page=<%=i%>"><%=i%></a>&nbsp;
                    <%
                            }else{
                    %>
                        <a href="<%=request.getContextPath()%>/adminbill?page=<%=i%>"><%=i%></a>&nbsp;
                    <%
                             }
                        }
                        if (currentPage < numberOfPages) {
                            int next = currentPage + 1;
					%>		
                        <a href="<%=request.getContextPath()%>/adminbill?page=<%=next%>">Sau</a>&nbsp;
                    <%
    						}
                        }
   					%>
                    </div>
                </div>
			</div>
<script>
	function checkBill(x){
		var bill_id = x;
		var check = confirm('Xác nhận ship đơn thành công ? Lưu ý : Thao tác này sẽ không thể hoàn tác !');
		if(check){
			//$("#check"+x+"").attr('disabled','disabled');
			$("#check"+x+"").attr('<h6 style="color: red;font-weight: bold;">Ship thành công</h6>');
			$.ajax({
				url : '<%=request.getContextPath()%>/checkbill',
				type : 'post',
				data :{bill_id : bill_id},
				success : function(data) {
				}
			});
		}else{
			$('#check').prop('checked', false);
		}
	}
</script>       
	                                <%
                                    	}else{
                                    	if(request.getAttribute("listBillStaff") != null){
                                    		listBill = (ArrayList<Bill>)request.getAttribute("listBillStaff");
                                    		for(Bill bill : listBill){
									%>
                                        <tr>
                                            <td><%=bill.getBill_id()%></td>
                                            <td><%=bill.getBill_product_id()%></td>
                                            <td><img src="<%=request.getContextPath()%>/templates/public/images/<%=bill.getBill_product_image()%>" style="width: 250px;height: auto" /></td>
                                            <td><%=bill.getBill_product_name()%></td>
                                            <td><%=bill.getBill_product_amount()%></td>
                                            <td><%=bill.getBill_product_price()%></td>
                                            <td><%=bill.getBill_product_promotion()%></td>
                                            <td><%=bill.getBill_product_money()%></td>
                                            <td><%=bill.getUser_fullname()%></td>
                                            <td><%=bill.getUser_id()%></td>
                                            <td><%=bill.getDate()%></td>
                                            <%
                                            	if(bill.getStatus() == 1){
                                            %>
                                            <td><h6 style="color: red;font-weight: bold;">Ship thành công</h6></td>
                                            <%}else{ %>
                                             <td id="change"><input id="check<%=bill.getBill_id()%>" type="checkbox" onclick="checkBill(<%=bill.getBill_id()%>)" data-toggle="toggle" data-onstyle="success" data-offstyle="danger"></td>
                                            <%} %>
                                        </tr>
                                     <%
                                    		}
                                    	}
                                    	
                                     %>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>

                </div>
                <!-- /.container-fluid -->
                 <div class="container">
                             <%
                           		int numberOfPages=(Integer)request.getAttribute("numberOfPages");
                           		int currentPage=(Integer)request.getAttribute("currentPage");
                           		if(listBill != null && listBill.size() > 0 && numberOfPages > 1){	
                            %>
                 	<h5 style="float: left;color: #4E73DF;font-weight: bold;">Trang <%=currentPage%> của <%=numberOfPages%></h5>
                    <div class="row" style="float: right;padding-bottom: 25px;">
                    <%
    					if (currentPage > 1) {
     						int back = currentPage - 1;
    				%>
                        <a href="<%=request.getContextPath()%>/adminbill?page=<%=back%>">Trước</a>&nbsp;
                    <%
                          }
                    %>
                    <%
                        for(int i=1;i<=numberOfPages;i++){
                            if(currentPage==i){
                    %>
                        <a href="<%=request.getContextPath()%>/adminbill?page=<%=i%>"><%=i%></a>&nbsp;
                    <%
                            }else{
                    %>
                        <a href="<%=request.getContextPath()%>/adminbill?page=<%=i%>"><%=i%></a>&nbsp;
                    <%
                             }
                        }
                        if (currentPage < numberOfPages) {
                            int next = currentPage + 1;
					%>		
                        <a href="<%=request.getContextPath()%>/adminbill?page=<%=next%>">Sau</a>&nbsp;
                    <%
    						}
                        }
                                    	}
   					%>
                    </div>
                </div>
<script>
	function checkBill(x){
		var bill_id = x;
		var check = confirm('Xác nhận ship đơn thành công ? Lưu ý : Thao tác này sẽ không thể hoàn tác !');
		if(check){
			//$("#check"+x+"").attr('disabled','disabled');
			$("#change").html('<h6 style="color: red;font-weight: bold;">Ship thành công</h6>');
			$.ajax({
				url : '<%=request.getContextPath()%>/checkbill',
				type : 'post',
				data :{bill_id : bill_id},
				success : function(data) {
				}
			});
		}else{
			$("#check"+x+"").prop('checked', false);
		}
	}
</script>       
<%@ include file="/templates/admin/inc/footer.jsp" %>