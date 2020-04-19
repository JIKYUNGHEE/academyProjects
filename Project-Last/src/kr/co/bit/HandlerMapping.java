package kr.co.bit;

import java.util.HashMap;
import java.util.Map;

import kr.co.bit.controller.AlbumController;
import kr.co.bit.controller.Controller;
import kr.co.bit.controller.DeleteController;
import kr.co.bit.controller.DeleteMController;
import kr.co.bit.controller.DetailController;
import kr.co.bit.controller.DetailMController;
import kr.co.bit.controller.IndexController;
import kr.co.bit.controller.JoinController;
import kr.co.bit.controller.JoinFormController;
import kr.co.bit.controller.KakaoJoinFormController;
import kr.co.bit.controller.KakaoLoginController;
import kr.co.bit.controller.ListMController;
import kr.co.bit.controller.LoginController;
import kr.co.bit.controller.LogoutController;
import kr.co.bit.controller.MarketComDeleteController;
import kr.co.bit.controller.MarketCommentController;
import kr.co.bit.controller.MarketCommentDetailController;
import kr.co.bit.controller.MarketDeleteController;
import kr.co.bit.controller.MarketDetailController;
import kr.co.bit.controller.MarketListController;
import kr.co.bit.controller.MarketReplyController;
import kr.co.bit.controller.MarketReplyDeleteController;
import kr.co.bit.controller.MarketUpdateController;
import kr.co.bit.controller.MarketUpdateFormController;
import kr.co.bit.controller.MarketWriteController;
import kr.co.bit.controller.MarketWriteFormController;
import kr.co.bit.controller.MyWriteController;
import kr.co.bit.controller.MypageController;
import kr.co.bit.controller.ReWriteController;
import kr.co.bit.controller.ReWriteUpController;
import kr.co.bit.controller.TSearchController;
import kr.co.bit.controller.TipCommentController;
import kr.co.bit.controller.TipCommentDeleteController;
import kr.co.bit.controller.TipCommentDetailController;
import kr.co.bit.controller.TipListController;
import kr.co.bit.controller.TipReplyController;
import kr.co.bit.controller.TipReplyDeleteController;
import kr.co.bit.controller.UpdateMController;
import kr.co.bit.controller.WRegisController;
import kr.co.bit.controller.WRegisFinController;
import kr.co.bit.controller.WriteFormController;

public class HandlerMapping {
	private Map<String, Controller> mappings = null;

	public HandlerMapping() {
      mappings = new HashMap<>();
      mappings.put("/index.do", new IndexController());
      mappings.put("/tipList.do", new TipListController());
      mappings.put("/joinForm.do", new JoinFormController());
      mappings.put("/join.do", new JoinController());
      mappings.put("/writeForm.do", new WriteFormController());
	  mappings.put("/wRegis.do", new WRegisController());
	  mappings.put("/wRegisFin.do", new WRegisFinController());
	  mappings.put("/detail.do", new DetailController());
	  mappings.put("/delete.do", new DeleteController());
	  mappings.put("/login.do", new LoginController());
	  mappings.put("/logout.do", new LogoutController());
	  mappings.put("/tSearch.do", new TSearchController());
	  mappings.put("/reWrite.do", new ReWriteController());
	  mappings.put("/reWriteUp.do", new ReWriteUpController());
	  mappings.put("/album.do", new AlbumController());
	  mappings.put("/mypage.do", new MypageController());
	  mappings.put("/listM.do", new ListMController());
	  mappings.put("/updateM.do", new UpdateMController());
	  mappings.put("/detailM.do", new DetailMController());
	  mappings.put("/deleteM.do", new DeleteMController());
	  
	  mappings.put("/kakaoLogin.do", new KakaoLoginController());
	  mappings.put("/kakaoJoin.do", new KakaoJoinFormController());
	  
	  mappings.put("/sellList.do", new MarketListController());
	  mappings.put("/marketWrite.do", new MarketWriteController());
	  mappings.put("/marketWriteForm.do", new MarketWriteFormController());
	  mappings.put("/marketDetail.do", new MarketDetailController());
	  mappings.put("/marketComment.do", new MarketCommentController());
	  mappings.put("/marketCommentDetail.do", new MarketCommentDetailController());
	  mappings.put("/marketReply.do", new MarketReplyController());
	  mappings.put("/marketDelete.do", new MarketDeleteController());
	  mappings.put("/marketReplyDel.do", new MarketReplyDeleteController());
	  mappings.put("/marketBoardComDelete.do", new MarketComDeleteController());
	  mappings.put("/marketBoardUpdate.do", new MarketUpdateController());
	  mappings.put("/marketBoardUpdateForm.do", new MarketUpdateFormController());
	  
	  
	  mappings.put("/myWrite.do", new MyWriteController());
	  mappings.put("/tipComment.do", new TipCommentController());
	  mappings.put("/tipCommentDetail.do", new TipCommentDetailController());
	  mappings.put("/tipComDelete.do", new TipCommentDeleteController());
	  mappings.put("/tipReply.do", new TipReplyController());
	  mappings.put("/tipReplyDel.do", new TipReplyDeleteController());
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
   
   }

	public Controller getController(String uri) {
		return mappings.get(uri);
	}
}