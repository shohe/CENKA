package jp.ac.hal.pdf;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfChunk;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * Servlet implementation class PdfServlet
 */
@WebServlet("/PdfServlet")
public class PdfServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PdfServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// 0 PDFを返すことを知らせる
		response.setContentType("application/pdf");
		
		try {
			// 1 空白のドキュメントを作成
			Document pdfDocument = new Document(PageSize.A4, 50, 50, 50, 50);
			// 2 Writerを生成する
			PdfWriter writer = PdfWriter.getInstance(pdfDocument, response.getOutputStream());
			// 3 ドキュメントを開く
			pdfDocument.open();
			// 4 コンテンツを記述する
			// 4-1 ベースとなるフォントを作成
			BaseFont baseFont = BaseFont.createFont(
					"HeiseiKakuGo-W5",
					"UniJIS-UCS2-H",
					BaseFont.NOT_EMBEDDED);
			
			// 4-2 フォントの作成
			Font font = new Font(baseFont,	// 書き込みに使用すベースフォント
								10,			// フォントサイズ
								Font.BOLD);	// 文字装飾
			
			// 4-3 段落の作成
			Paragraph p1 = new Paragraph("おおたに", font);
			Paragraph p2 = new Paragraph("しょうへい", font);
			
			// 4-4 ドキュメントに追加
			pdfDocument.add(p1);
			pdfDocument.add(p2);
			
			// 5 ファイルの書き出し
			writer.flush();
			pdfDocument.close();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
