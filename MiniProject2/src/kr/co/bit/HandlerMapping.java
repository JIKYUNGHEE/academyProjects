package kr.co.bit;

import java.util.HashMap;
import java.util.Map;

import kr.co.bit.controller.Controller;
import kr.co.bit.controller.DeleteController;
import kr.co.bit.controller.DetailController;
import kr.co.bit.controller.FreeBoardListController;
import kr.co.bit.controller.JoinController;
import kr.co.bit.controller.JoinProcessController;
import kr.co.bit.controller.JoinpetController;
import kr.co.bit.controller.JoinpetProcessController;
import kr.co.bit.controller.LikeDeleteController;
import kr.co.bit.controller.LikeListController;
import kr.co.bit.controller.LikePopUpController;
import kr.co.bit.controller.LikeReplyController;
import kr.co.bit.controller.LikeReplyDeleteController;
import kr.co.bit.controller.LikeUploadController;
import kr.co.bit.controller.LikeUploadProcessController;
import kr.co.bit.controller.LoginProcessController;
import kr.co.bit.controller.LogoutController;
import kr.co.bit.controller.MeetingDeleteController;
import kr.co.bit.controller.MeetingInsertController;
import kr.co.bit.controller.MeetingViewController;
import kr.co.bit.controller.ModifyController;
import kr.co.bit.controller.ModifyFormController;
import kr.co.bit.controller.MyinfoDetailController;
import kr.co.bit.controller.MyinfoModifyController;
import kr.co.bit.controller.MyinfoModifyFormController;
import kr.co.bit.controller.MypetinfoDeleteController;
import kr.co.bit.controller.MypetinfoModifyController;
import kr.co.bit.controller.MypetinfoModifyFormController;
import kr.co.bit.controller.QnaAnswerController;
import kr.co.bit.controller.QnaBoardController;
import kr.co.bit.controller.QnaBoard_S_Controller;
import kr.co.bit.controller.QnaGetController;
import kr.co.bit.controller.ReplyDeleteController;
import kr.co.bit.controller.ReplyWriteController;
import kr.co.bit.controller.WalkDeleteController;
import kr.co.bit.controller.WalkDetailController;
import kr.co.bit.controller.WalkListController;
import kr.co.bit.controller.WalkReplyController;
import kr.co.bit.controller.WalkReplyDeleteController;
import kr.co.bit.controller.WalkUploadController;
import kr.co.bit.controller.WalkUploadProcessController;
import kr.co.bit.controller.WriteController;
import kr.co.bit.controller.WriteFormController;
import kr.co.bit.controller.meetingCheckController;

public class HandlerMapping {
	private Map<String, Controller> mappings = null;
	
	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		mappings.put("/freeBoardList.do", new FreeBoardListController());
		mappings.put("/writeForm.do", new WriteFormController());	
		mappings.put("/detail.do", new DetailController());
		mappings.put("/write.do", new WriteController());
		mappings.put("/modifyForm.do", new ModifyFormController());
		mappings.put("/delete.do", new DeleteController());
		mappings.put("/modify.do", new ModifyController());
		mappings.put("/ReplyWriteController.do", new ReplyWriteController());
		mappings.put("/ReplyDeleteController.do", new ReplyDeleteController());		
		mappings.put("/loginProcess.do", new LoginProcessController());
		mappings.put("/logout.do", new LogoutController());
		mappings.put("/join.do", new JoinController());
		mappings.put("/joinProcess.do", new JoinProcessController());
		mappings.put("/joinPet.do", new JoinpetController());
		mappings.put("/joinPetProcess.do", new JoinpetProcessController());
		mappings.put("/meetingInsert.do", new MeetingInsertController());
		mappings.put("/meetingDelete.do", new MeetingDeleteController());
		mappings.put("/meetingView.do", new MeetingViewController());
		mappings.put("/meetingCheck.do", new meetingCheckController());
		mappings.put("/myinfoDetail.do", new MyinfoDetailController());
		mappings.put("/myinfoModify.do", new MyinfoModifyController());		
		mappings.put("/myinfoModifyForm.do", new MyinfoModifyFormController());
		mappings.put("/mypetinfoModifyForm.do", new MypetinfoModifyFormController());
		mappings.put("/mypetinfoModify.do", new MypetinfoModifyController());
		mappings.put("/mypetinfoDelete.do", new MypetinfoDeleteController());
		mappings.put("/qnaBoard.do", new QnaBoardController());
		mappings.put("/qnaBoard_S.do", new QnaBoard_S_Controller());
		mappings.put("/qnaGet.do", new QnaGetController());
		mappings.put("/qnaAnswer.do", new QnaAnswerController());
		mappings.put("/like.do", new LikeListController());
		mappings.put("/likeUpload.do", new LikeUploadController());
		mappings.put("/likeUploadProcess.do", new LikeUploadProcessController());
		mappings.put("/likePopUp.do", new LikePopUpController());
		mappings.put("/likeDelete.do", new LikeDeleteController());
		mappings.put("/likeReply.do", new LikeReplyController());
		mappings.put("/likeReplyDelete.do", new LikeReplyDeleteController());
		mappings.put("/walk.do", new WalkListController());
		mappings.put("/walkUpload.do", new WalkUploadController());
		mappings.put("/walkUploadProcess.do", new WalkUploadProcessController());
		mappings.put("/walkDetail.do", new WalkDetailController());
		mappings.put("/walkReply.do", new WalkReplyController());
		mappings.put("/walkDelete.do", new WalkDeleteController());
		mappings.put("/walkReplyDelete.do", new WalkReplyDeleteController());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	public Controller getContoller(String uri) {
		return mappings.get(uri);
	}
	
}
