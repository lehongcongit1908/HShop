<%@ page pageEncoding="utf-8"%>
<div class="modal fade" id="send-dialog" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">GỬI HÀNG HÓA CHO BẠN BÈ/NGƯỜI THÂN</h4>
            </div>
            <div class="modal-body">
            <div class="row">
                <div class="form-group col-sm-6">
			        <label>Người gửi:</label>
			        <input id="sender" placeholder="Sender Email?" class="form-control">
			    </div>
			    <div class="form-group col-sm-6">
			        <label>Người nhận:</label>
			        <input id="receiver" placeholder="Receiver Email?" class="form-control">
			    </div>
			 </div>
			    <div class="form-group">
			        <label>Tiêu đề:</label>
			        <input id="subject" placeholder="Subject?" class="form-control">
			    </div>
			    <div class="form-group">
			        <label>Lời nhắn:</label>
			        <textarea id="content" placeholder="Content?" class="form-control"></textarea>
			    </div>
            </div>
            <div class="modal-footer">
            	<div id="loading" style="display:none" class="pull-left">
            		<img src="/static/images/loading.gif" style="width: 16px">
            		Vui lòng trong giây lát...
            	</div>
                <button class="btn btn-default nn-share-send">Send</button>
            </div>
        </div>
    </div>
</div>