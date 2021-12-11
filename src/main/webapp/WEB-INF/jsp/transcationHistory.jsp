<!DOCTYPE html>
<html lang="en"
      xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout"
      layout:decorate="_layout">

<body>

<div layout:fragment="content">
    <div class="content-wrap">
        <div class="main">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-8 p-r-0 title-margin-right">
                        <div class="page-header">
                            <div class="page-title">
                                <h1>Transaction History</span></h1>
                            </div>
                        </div>
                    </div>
                    <!-- /# column -->
                    <div class="col-lg-4 p-l-0 title-margin-left">
                        <div class="page-header">
                            <div class="page-title">
                                <ol class="breadcrumb">
                                    <li class="breadcrumb-item"><a href="#">Dashboard</a></li>
                                    <li class="breadcrumb-item active">Table-Export</li>
                                </ol>
                            </div>
                        </div>
                    </div>
                    <!-- /# column -->
                </div>
                <!-- /# row -->
                <section id="main-content">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="card">
                                <div class="bootstrap-data-table-panel">
                                    <div class="table-responsive">
                                        <table  class="table table-striped table-bordered">
                                            <thead>
                                                <tr>
                                                    <th>Transaction ID</th>
                                                    <th>Account Name</th>
                                                    <th>Transaction Type</th>
                                                    <th>Amount</th>
                                                     <th>Status</th>
                                                      <th>Reason</th>
                                                       <th>Created at</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <td>1</td>
                                                    <td>System Architect</td>
                                                    <td>deposit</td>
                                                    <td>$320,800</td>
                                                    <td>Success</td>
                                                    <td>Deposit Funds successful</td>
                                                    <td>2021-10-12</td>
                                                </tr>
                                              
                                                
                                                
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                            <!-- /# card -->
                        </div>
                        <!-- /# column -->
                    </div>
                    <!-- /# row -->

                    <div class="row">
                        <div class="col-lg-12">
                            <div class="footer">
                                <p>2018 © Admin Board. - <a href="#">example.com</a></p>
                            </div>
                        </div>
                    </div>
                </section>
            </div>
        </div>
       </div>


        
    
</div>




</body>

</html>