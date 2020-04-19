package kr.co.bit.page;
import java.util.List;

import kr.co.bit.board.vo.BoardVO;

public class BoardPage {
	private int total;
	private int currentPage;
	private List<BoardVO> boardList;
	private int totalPages;
	private int startPage;
	private int endPage;
	public BoardPage() {
		super();
	}
	public BoardPage(int total, int currentPage, int size, List<BoardVO> boardList) {
		this.total = total;
		this.currentPage=currentPage;
		this.boardList=boardList;
		
		if(total == 0) {
			totalPages = 0;
			startPage = 0;
			endPage = 0;
		} else {
			totalPages = total/size;
			if(total%size > 0) {
				totalPages++;
			}
			int modVal = currentPage%5;
			startPage = currentPage/5*5+1;
			if(modVal==0)
				startPage-=5;
			
			endPage= startPage+4;
			if(endPage>totalPages)
				endPage=totalPages;
			
		}
	}

	
	
	public int getTotal() {
		return total;
	}
	public boolean hasNoBoards() {
		return total == 0;
	}
	
	public boolean hasBoards() {
		return total > 0;
	}
	public int getCurrentPage() {
		return currentPage;
	}

	public List<BoardVO> getBoardList() {
		return boardList;
	}
	
	public int getTotalPages() {
		return totalPages;
	}

	public int getStartPage() {
		return startPage;
	}

	public int getEndPage() {
		return endPage;
	}
	
	
}
