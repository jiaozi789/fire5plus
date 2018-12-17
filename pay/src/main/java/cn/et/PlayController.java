package cn.et;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PlayController {
	/**
	 * 测试数据
	 */
	static List<Player> playerList=new ArrayList();
	static {
		playerList.add(new Player("1","1.mp4","1.jpg","花丛中一朵野花 飘出好漂亮的蓝色啊"));
		playerList.add(new Player("2","1.mp4","2.jpg","美女就是腿长长"));
		playerList.add(new Player("3","1.mp4","3.jpg","第一次出现这么漂亮的豪车"));
		playerList.add(new Player("4","1.mp4","4.jpg","蜡笔小新的小屁屁 	"));
		playerList.add(new Player("5","1.mp4","5.jpg","明信片就应该这么写"));
		playerList.add(new Player("6","1.mp4","7.jpg","南瓜排队莱罗"));
		playerList.add(new Player("7","1.mp4","8.jpg","意思意思啊 。。。"));
		playerList.add(new Player("8","1.mp4","9.jpg","中国镇压么真强大啊"));
	}
	 public static void main(String[] args) {
		
	}
	 @ResponseBody
	 @RequestMapping("/list")
	 List<Player> home(Integer start,Integer length) {
		 int endIndex=start+length;
		 if(start>=playerList.size()) {
			 return new ArrayList<Player>();
		 }
		 if(playerList.size()<endIndex) {
			 endIndex=playerList.size();
		 }
		 return playerList.subList(start, endIndex);
     }
	 @RequestMapping("/video")
	 public void video(String fileName,HttpServletResponse response) throws IOException {
		 if(fileName==null){
			 return;
		 }
		response.setContentType("video/mp4; charset=utf-8");   
		//response.setHeader("Content-Disposition", "attachment;filename="  + fileName);
		InputStream is=this.getClass().getResourceAsStream("/myplayer/"+fileName);
		FileCopyUtils.copy(is, response.getOutputStream());
		is.close();
		response.flushBuffer();
	 }
	 @RequestMapping("/view")
	 public void write(String fileName,HttpServletResponse response) throws IOException {
		if(fileName==null){
			return;
		}
		InputStream is=this.getClass().getResourceAsStream("/myplayer/"+fileName);
		FileCopyUtils.copy(is, response.getOutputStream());
		is.close();
		response.flushBuffer();
	 }
	 
	 
	 
	 
}
