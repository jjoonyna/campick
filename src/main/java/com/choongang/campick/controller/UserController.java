package com.choongang.campick.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.choongang.campick.model.User;
import com.choongang.campick.service.UserService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserController {

	// 서비스
	private final UserService service;

	// security
	private final PasswordEncoder passwordEncoder;
	
	//닉네임 중복확인 안보여서 추가했습니다
	@GetMapping("nickname_check/{user_nick}")
	@ResponseBody
	public ResponseEntity<Integer> nickname_check(@PathVariable("user_nick") String user_nick){
		int result = 0;
		User user = service.nickcheck(user_nick);
		if(user == null) {
			result=0;
		}else {
			result=1;
		}
		return new ResponseEntity<>(result,HttpStatus.OK);
	}
	
	//마찬가지로 id중복체크 안보여서 추가했습니다
	@GetMapping("id_check/{user_id}")
	@ResponseBody
	public ResponseEntity<Integer> id_check(@PathVariable("user_id") String user_id){
		int result = 0;
		User user = service.selectUser(user_id);
		if(user == null) {
			result=0;
		}else {
			result=1;
		}
		return new ResponseEntity<>(result,HttpStatus.OK);
	}
	
	
	////////////////////////////////////////////// 
	//  										//	
	//  										//	
	// 			일반 회원 기능 		start			// 
	//  										//	
	//  										//	
	////////////////////////////////////////////// 

	/*
	 * 일반 회원 가입
	 */
	@PostMapping("/insert_user")
	@ResponseBody
	public ResponseEntity<Integer> insert_user(@RequestBody User user) {

		// 뿌려지는 것 확인
		System.out.println("회원가입 합시다!");

		// 뿌려지는 것 확인 : postman 에 값을 넣으면 콘솔에 입력한 값들이 나온다
		System.out.println(user);

		int result = 0; // 결과 값 받는 객체 선언

		/*
		 * security로 비번 암호화 하기
		 */
		String encpassword = passwordEncoder.encode(user.getUser_pw());
		System.out.println("비번 암호화:" + encpassword);
		user.setUser_pw(encpassword);
		result = service.insertUser(user);

		if (result == 0) { // 만약 결과 값에 db가 저장이 안될 경우 --> 저장되면 값이 1로 된다
			System.out.println("회원 가입 실패.");
		}
		System.out.println("result:" + result);
		System.out.println("회원 가입 성공!");
		
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
//
//	/*
//	 * 파일 업로드 포함 회원가입
//	 */
//	@PostMapping("/bizmember_join")
//	@ResponseBody
//	public ResponseEntity<Integer> bizmember_join(@RequestParam("user_pic") MultipartFile mf, @RequestBody User user)
//			throws Exception {
//
//		System.out.println("회원가입 합시다!");
//		System.out.println(user.getUser_id() + user.getUser_nick() + user.getUser_pw() + user.getUser_nm()
//				+ user.getUser_biz() + user.getUser_tel());
//		System.out.println(user.getUser_code() + user.getUser_addr1() + user.getUser_addr2() + user.getUser_email()
//				+ user.getUser_kind());
//
//		int result = 0;
//
//		String filename = mf.getOriginalFilename();
//		int size = (int) mf.getSize();
//		String uploadPath = "/your/upload/path"; // 파일 업로드 경로 설정
//
//		if (size > 0) {
//			String extension = filename.substring(filename.lastIndexOf("."), filename.length());
//			UUID uuid = UUID.randomUUID();
//			String newfilename = uuid.toString() + extension;
//
//			if (size > 100000) { // 100KB
//				result = 1;
//				return new ResponseEntity<>(result, HttpStatus.OK);
//			} else if (!extension.equals(".jpg") && !extension.equals(".jpeg") && !extension.equals(".gif")
//					&& !extension.equals(".png")) {
//				result = 2;
//				return new ResponseEntity<>(result, HttpStatus.OK);
//			}
//
//			mf.transferTo(new File(uploadPath + "/" + newfilename));
//			user.setUser_pic(uploadPath); // 파일 업로드 경로 설정
//		}
//
//		String encpassword = passwordEncoder.encode(user.getUser_pw());
//		System.out.println("비번 암호화:" + encpassword);
//		user.setUser_pw(encpassword);
//		result = service.insert(user);
//
//		if (result == 0) {
//			System.out.println("값이 전달안됨.");
//		}
//		System.out.println("result:" + result);
//
//		return new ResponseEntity<>(result, HttpStatus.OK);
//	}

	/*
	 * 일반 회원 로그인폼
	 */
    @GetMapping("/login")
    public String loginPage() {
        return "user/login"; // 실제 JSP 파일의 경로에 맞게 수정해야 합니다.
    }
	
	
	/*
	 * 일반 회원 로그인
	 */
	@PostMapping("/login_user")
	@ResponseBody
	public ResponseEntity<Integer> login_user(@RequestBody User user,HttpSession session) {
		//	@PathVariable("user_id") String user_id

		System.out.println("user_id : " + user.getUser_id()); // 입력한 아이디가 제대로 들어가는지 확인

		User db = service.selectUser(user.getUser_id()); // 회원이 있는지 없는지 확인
		int result = 0;
		if (passwordEncoder.matches(user.getUser_pw(), db.getUser_pw())) { // 암호화된 비밀번호와 회원이 입력한 값을 인코딩하여 비교, 일치할 경우
			if (db.getUser_kind().equals("u")) { // db의 회원상태가 u로 일치할 경우 --> 탈퇴 회원의 로그인을 방지하기 위함
				result = 1;
				// 따라서 위의 두 조건절이 true 값이어야 로그인 가능함.
				System.out.println("로그인 완료!");
				session.setAttribute("user_id", db.getUser_id());
				session.setAttribute("user_kind", db.getUser_kind());
				return new ResponseEntity<>(result, HttpStatus.OK);
			}
		}

		System.out.println("로그인 실패.");
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

	}

	//유저 정보 불러오는게 안보여서 일단 하나 만들었습니다
	@GetMapping("/user_info")
	@ResponseBody
	public ResponseEntity<Map<String,Object>> user_info(HttpSession session){
		Map map = new HashMap();
		String user_id = (String)session.getAttribute("user_id");
		System.out.println(user_id);
		User db = service.selectUser(user_id); // 회원이 있는지 없는지 확인
		map.put("user_id", db.getUser_id());
		map.put("user_nm", db.getUser_nm());
		map.put("user_nick", db.getUser_nick());
		map.put("user_birth", db.getUser_birth());
		map.put("user_tel", db.getUser_tel());
		map.put("user_code", db.getUser_code());
		map.put("user_addr1", db.getUser_addr1());
		map.put("user_addr2", db.getUser_addr2());
		map.put("user_email", db.getUser_email());
		
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
	
	/*
	 * 일반 회원 정보 수정 
	 */
    @GetMapping("/update_user")
    public String updateuser() {
        return "user/user_mypage"; // 실제 JSP 파일의 경로에 맞게 수정해야 합니다.
    }
	
	/*
	 * 일반 회원 정보 수정
	 */
	@PostMapping("/update_user")
	@ResponseBody
	public ResponseEntity<Integer> update_user(@RequestBody User user) {

		int result = 0; // 결과 값 받는 객체 선언

		System.out.println(user.getUser_id()); // 회원이 입력한 값 출력해보기

		User db = service.selectUser(user.getUser_id()); // select된 회원 값을 db 객체에 넣는다

		if (passwordEncoder.matches(user.getUser_pw(), db.getUser_pw())) { // 암호화된 비밀번호와 회원이 입력한 값을 인코딩하여 비교, 일치할 경우
			result = service.updateUser(user); // update를 result 객체에 대입
		} else { // 일치하지 않을 경우, result = -1 반환
			result = -1;
		}
		System.out.println("result:" + result);

		return new ResponseEntity<>(result, HttpStatus.OK);
	}

//	/*
//	 * 파일 업로드 포함 일반 회원 정보 수정
//	 */
//	// @PostMapping("/bizmember_update")
//	// @ResponseBody
//	// public ResponseEntity<Integer> bizmember_update(@RequestParam(value =
//	// "user_pic", required = false) MultipartFile mf,
////	                                                   @ModelAttribute Biz biz) {
//	//
////	       int result = 0;     // 결과 값 받는 객체 선언
//	//
////	       System.out.println(biz.getUser_id());    // 회원이 입력한 값 출력해보기
//	//
////	       Biz db = service.select(biz.getUser_id());        // select된 회원 값을 db 객체에 넣는다
//	//
////	       if (passwordEncoder.matches(biz.getUser_pw(), db.getUser_pw())) {    // 암호화된 비밀번호와 회원이 입력한 값을 인코딩하여 비교, 일치할 경우
////	           // 파일 업로드 처리
////	           if (mf != null && !mf.isEmpty()) {
////	               try {
////	                   String filename = mf.getOriginalFilename();
////	                   String uploadPath = "/your/upload/path"; // 파일 업로드 경로 설정
//	//
////	                   // 파일 처리 및 업로드
////	                   // 예시: 파일 저장 경로에 저장
////	                   File file = new File(uploadPath, filename);
////	                   mf.transferTo(file);
//	//
////	                   biz.setUser_pic(uploadPath + "/" + filename); // 파일 경로 설정
////	               } catch (Exception e) {
////	                   e.printStackTrace();
////	                   return new ResponseEntity<>(-1, HttpStatus.INTERNAL_SERVER_ERROR);
////	               }
////	           }
//	//
////	           result = service.update(biz);                                    // update를 result 객체에 대입
////	       } else {                                                            // 일치하지 않을 경우, result = -1 반환
////	           result = -1;
////	       }
////	       System.out.println("result:" + result);
//	//
////	       return new ResponseEntity<>(result, HttpStatus.OK);
//	// }

	/*
	 * 일반 회원 삭제
	 */
	@PostMapping("delete_user")
	@ResponseBody
	public ResponseEntity<Integer> delete_user(@RequestBody User user) {

		int result = 0; // 결과 값 받는 객체 선언

		User db = service.selectUser(user.getUser_id()); // select된 회원 값을 db 객체에 넣는다

		if (passwordEncoder.matches(user.getUser_pw(), db.getUser_pw())) { // 암호화된 비밀번호와 회원이 입력한 값을 인코딩하여 비교, 일치할 경우
			result = service.deleteUser(user.getUser_id()); // // delete를 result 객체에 대입
		} else { // 일치하지 않을 경우, result = -1 반환
			result = -1;
		}
		System.out.println("result:" + result); // 결과값 test 출력

		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	/*
	 * 일반 회원 아이디 찾기
	 */
	@PostMapping("/finduser_id")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> finduser_id(@RequestBody User user) {

		System.out.println("user_tel : " + user.getUser_tel()); // 입력한 user test 출력

		User db = service.findUser(user.getUser_tel()); // select된 회원 값을 user 객체에 넣는다

		System.out.println("db : " + db);

		Map<String, Object> resultMap = new HashMap<>();

		if (db.getUser_kind().equals("u")) { // 가져온 user가 null이 아닐 경우, 아이디 찾기 성공
			System.out.println("아이디 찾기 성공!");
			String user_id = db.getUser_id();
			resultMap.put("user_id", user_id);
			return new ResponseEntity<>(resultMap, HttpStatus.OK);
		} else { // 실패
			System.out.println("아이디 찾기 실패ㅠ");
			return new ResponseEntity<>(resultMap, HttpStatus.BAD_REQUEST);
		}
	}

	/*
	 * 일반 회원 비밀번호 찾기
	 */
	@PostMapping("/finduser_pwd")
	@ResponseBody
	public ResponseEntity<Integer> finduser_pwd(@RequestBody User user) {

		System.out.println("user_id : " + user.getUser_tel());

		User db = service.findUser(user.getUser_tel());

		System.out.println("db : " + db);
		int result =0;

		if (db.getUser_kind().equals("u")) {
			System.out.println("비밀번호 찾기 성공!");
			result= 1;
			return new ResponseEntity<>(result, HttpStatus.OK);
		} else { // 실패
			System.out.println("비밀번호 찾기 실패ㅠ");
			return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
		}
	}
	
	/* 
	 * 일반 회원 비밀번호 수정 : pw 찾고 수정
	 */
	@PostMapping("/updateuser_pwd")
	@ResponseBody
	public ResponseEntity<Integer> updateuser_pwd(@RequestBody User user) {
		
		int result = 0;		// 결과 값 받는 객체 선언
		System.out.println("user.getUser_pw()" + user.getUser_pw());	// 입력한 pw test 출력
		String encpassword = passwordEncoder.encode(user.getUser_pw());
		System.out.println("바뀐 비번 암호화:" + encpassword);
		user.setUser_pw(encpassword);

		result = service.updatePwd(user);
		
		if(result == 1) {
			
			return new ResponseEntity<>(result, HttpStatus.OK);
		} else {
			result = 0;
			return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
		}
		
	}

	/*
	 * 일반 회원 비밀번호 수정 : 마이페이지에서 비밀번호 수정
	 */
	@PostMapping("/updatemyuser_pwd")
	@ResponseBody
	public ResponseEntity<User> updatemyuser_pwd(@RequestBody User user) {

		int result = 0;

		System.out.println(user.getUser_pw());

		String encpassword = passwordEncoder.encode(user.getUser_pw());
		System.out.println("바뀐 비번 암호화:" + encpassword);
		user.setUser_pw(encpassword);

		result = service.updatePwd(user);

		User db = null;
		if (result == 1) {
			db = service.selectUser(user.getUser_id());
			return new ResponseEntity<>(db, HttpStatus.OK);
		} else {
			System.out.println("에러");
			return new ResponseEntity<>(user, HttpStatus.BAD_REQUEST);
		}
	}
	
	////////////////////////////////////////////// 
	//  										//	
	//  										//	
	// 			사업자 회원 기능 		start		// 
	//  										//	
	//  										//	
	////////////////////////////////////////////// 
	
	/* 
	 * 사업자 회원가입
	 */
	@PostMapping("/insert_biz")
	@ResponseBody
	public ResponseEntity<Integer> insert_biz(@RequestBody User user) {

		// 뿌려지는 것 확인
		System.out.println("회원가입 합시다!");

		// 뿌려지는 것 확인 : postman 에 값을 넣으면 콘솔에 입력한 값들이 나온다
		System.out.println(user);

		int result = 0;		// 결과 값 받는 객체 선언

		/* 
		 * security로 비번 암호화 하기 
		 */
		String encpassword = passwordEncoder.encode(user.getUser_pw());
		System.out.println("비번 암호화:" + encpassword);
		user.setUser_pw(encpassword);
		result = service.insertBiz(user);

		if (result == 0) {		// 만약 결과 값에 db가 저장이 안될 경우 --> 저장되면 값이 1로 된다
			System.out.println("값이 전달안됨.");
		}
		System.out.println("result:" + result);

		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	/* 
	 * 파일 업로드 포함 사업자 회원가입
	 *  */
//	@PostMapping("/insert_biz")
//	@ResponseBody
//	public ResponseEntity<Integer> insert_biz(@RequestParam("user_pic") MultipartFile mf, 
//	                                              @RequestBody User user) throws Exception {
//
//	    System.out.println("회원가입 합시다!");
//	    System.out.println(user.getUser_id() + user.getUser_nick() + user.getUser_pw() + user.getUser_nm()
//	            + user.getUser_biz() + user.getUser_tel());
//	    System.out.println(user.getUser_code() + user.getUser_addr1() + user.getUser_addr2() + user.getUser_email()
//	            + user.getUser_kind());
//
//	    int result = 0;
//
//	    String filename = mf.getOriginalFilename();
//	    int size = (int) mf.getSize();
//	    String uploadPath = "/your/upload/path"; // 파일 업로드 경로 설정
//
//	    if (size > 0) {
//	        String extension = filename.substring(filename.lastIndexOf("."), filename.length());
//	        UUID uuid = UUID.randomUUID();
//	        String newfilename = uuid.toString() + extension;
//	        
//	        if (size > 100000) { // 100KB
//	            result = 1;
//	            return new ResponseEntity<>(result, HttpStatus.OK);
//	        } else if (!extension.equals(".jpg") &&
//	                !extension.equals(".jpeg") &&
//	                !extension.equals(".gif") &&
//	                !extension.equals(".png")) {
//	            result = 2;
//	            return new ResponseEntity<>(result, HttpStatus.OK);
//	        }
//
//	        mf.transferTo(new File(uploadPath + "/" + newfilename));
//	        user.setUser_pic(uploadPath); // 파일 업로드 경로 설정
//	    }
//
//	    String encpassword = passwordEncoder.encode(user.getUser_pw());
//	    System.out.println("비번 암호화:" + encpassword);
//	    user.setUser_pw(encpassword);
//	    result = service.insertBiz(user);
//
//	    if (result == 0) {
//	        System.out.println("값이 전달안됨.");
//	    }
//	    System.out.println("result:" + result);
//
//	    return new ResponseEntity<>(result, HttpStatus.OK);
//	}


	/* 
	 * 사업자 회원 로그인
	 */
	@CrossOrigin(origins = "*")
	@PostMapping("/login_biz")
	@ResponseBody
	public ResponseEntity<Integer> login_biz(@RequestBody User user, HttpSession session) {

		System.out.println("user_id : " + user.getUser_id());	// 입력한 아이디가 제대로 들어가는지 확인

		User db = service.selectUser(user.getUser_id()); // 회원이 있는지 없는지 확인

		int result= 0;
		if (passwordEncoder.matches(user.getUser_pw(), db.getUser_pw())) {	// 암호화된 비밀번호와 회원이 입력한 값을 인코딩하여 비교, 일치할 경우
			if (db.getUser_kind().equals("b")) {	// db의 회원상태가 b로 일치할 경우 --> 탈퇴 회원의 로그인을 방지하기 위함
				result = 1;
				session.setAttribute("user_id", db.getUser_id());
				session.setAttribute("user_kind", db.getUser_kind());
				// 따라서 위의 두 조건절이 true 값이어야 로그인 가능함.
				System.out.println("로그인 완료!");
				return new ResponseEntity<>(result, HttpStatus.OK);
			}
		}

		System.out.println("로그인 실패.");
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

	}

	/* 
	 * 사업자 회원 정보 수정
	 */
	@PostMapping("update_biz")
	@ResponseBody
	public ResponseEntity<Integer> update_biz(@RequestBody User user) {

		int result = 0;		// 결과 값 받는 객체 선언

		System.out.println(user.getUser_id());	// 회원이 입력한 값 출력해보기
		
		User db = service.selectUser(user.getUser_id());		// select된 회원 값을 db 객체에 넣는다
		
		if (passwordEncoder.matches(user.getUser_pw(), db.getUser_pw())) {	// 암호화된 비밀번호와 회원이 입력한 값을 인코딩하여 비교, 일치할 경우
			result = service.updateBiz(user);									// update를 result 객체에 대입
		} else {															// 일치하지 않을 경우, result = -1 반환
			result = -1;								
		}
		System.out.println("result:" + result);

		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	/* 
	 * 파일 업로드 포함 사업자 회원 정보 수정
	 */
//	@PostMapping("/update_biz")
//	@ResponseBody
//	public ResponseEntity<Integer> update_biz(@RequestParam(value = "user_pic", required = false) MultipartFile mf,
//	                                                @ModelAttribute User user) {
//
//	    int result = 0;     // 결과 값 받는 객체 선언
//
//	    System.out.println(biz.getUser_id());    // 회원이 입력한 값 출력해보기
//
//	    User db = service.selectUser(biz.getUser_id());        // select된 회원 값을 db 객체에 넣는다
//
//	    if (passwordEncoder.matches(biz.getUser_pw(), db.getUser_pw())) {    // 암호화된 비밀번호와 회원이 입력한 값을 인코딩하여 비교, 일치할 경우
//	        // 파일 업로드 처리
//	        if (mf != null && !mf.isEmpty()) {
//	            try {
//	                String filename = mf.getOriginalFilename();
//	                String uploadPath = "/your/upload/path"; // 파일 업로드 경로 설정
//
//	                // 파일 처리 및 업로드
//	                // 예시: 파일 저장 경로에 저장
//	                File file = new File(uploadPath, filename);
//	                mf.transferTo(file);
//
//	                user.setUser_pic(uploadPath + "/" + filename); // 파일 경로 설정
//	            } catch (Exception e) {
//	                e.printStackTrace();
//	                return new ResponseEntity<>(-1, HttpStatus.INTERNAL_SERVER_ERROR);
//	            }
//	        }
//
//	        result = service.updateBiz(user);                                    // update를 result 객체에 대입
//	    } else {                                                            // 일치하지 않을 경우, result = -1 반환
//	        result = -1;
//	    }
//	    System.out.println("result:" + result);
//
//	    return new ResponseEntity<>(result, HttpStatus.OK);
//	}

	/* 
	 * 사업자 회원 삭제
	 */
	@PostMapping("delete_biz")
	@ResponseBody
	public ResponseEntity<Integer> delete_biz(@RequestBody User user) {
		
		int result = 0;		// 결과 값 받는 객체 선언
		
		User db = service.selectUser(user.getUser_id());		// select된 회원 값을 db 객체에 넣는다
		
		if (passwordEncoder.matches(user.getUser_pw(), db.getUser_pw())) {	// 암호화된 비밀번호와 회원이 입력한 값을 인코딩하여 비교, 일치할 경우
			result = service.deleteUser(user.getUser_id());					// // delete를 result 객체에 대입
		} else {															// 일치하지 않을 경우, result = -1 반환
			result = -1;
		}
		System.out.println("result:" + result);		// 결과값 test 출력

		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	/* 
	 * 사업자 회원 아이디 찾기
	 */
	@PostMapping("/findbiz_id")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> findbiz_id(@RequestBody User user) {

		System.out.println("user_biz : " + user.getUser_biz());	// 입력한 biz test 출력
		
		User db = service.selectBiz(user.getUser_biz());		// select된 회원 값을 biz 객체에 넣는다
		
		System.out.println("db : " + db);
		
		Map<String, Object> resultMap = new HashMap<>();


		if (db.getUser_kind().equals("b")) { // 가져온 user가 b일 경우, 아이디 찾기 성공
			System.out.println("아이디 찾기 성공!");
			String user_id = db.getUser_id();
			resultMap.put("user_id", user_id);
			return new ResponseEntity<>(resultMap, HttpStatus.OK);
		} else { // 실패
			System.out.println("아이디 찾기 실패ㅠ");
			return new ResponseEntity<>(resultMap, HttpStatus.BAD_REQUEST);
		}

	}

	/* 
	 * 사업자 회원 비밀번호 찾기
	 */
	@PostMapping("/findbiz_pwd")
	@ResponseBody
	public ResponseEntity<Integer> findbiz_pwd(@RequestBody User user) {

		System.out.println("user_biz : " + user.getUser_biz());
		
		User db = service.selectBiz(user.getUser_biz());
		
		System.out.println("db : " + db);
		
		int result= 0;

		if (db.getUser_kind().equals("b")) {
			System.out.println("비밀번호 찾기 성공!");
			result = 1;
			return new ResponseEntity<>(result, HttpStatus.OK);
		} else { // 실패
			System.out.println("비밀번호 찾기 실패ㅠ");
			return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
		}
	}

	/* 
	 * 사업자 회원 비밀번호 수정 : pw 찾고 수정
	 */
	@PostMapping("/updatebiz_pwd")
	@ResponseBody
	public ResponseEntity<Integer> updatebiz_pwd(@RequestBody User user) {
		
		int result = 0;		// 결과 값 받는 객체 선언
		System.out.println("biz.getUser_pw()" + user.getUser_pw());	// 입력한 pw test 출력
		String encpassword = passwordEncoder.encode(user.getUser_pw());
		System.out.println("바뀐 비번 암호화:" + encpassword);
		user.setUser_pw(encpassword);

		result = service.updatePwd(user);
		
		if(result == 1) {
			
			return new ResponseEntity<>(result, HttpStatus.OK);
		} else {
			result = 0;
			return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
		}
		
	}

	/* 
	 * 사업자 회원 비밀번호 수정 : 마이페이지에서 비밀번호 수정
	 */
	@PostMapping("/updatemybiz_pwd")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> updatemybiz_pwd(@RequestBody User user) {

		int result = 0;
		
		String encpassword = passwordEncoder.encode(user.getUser_pw());
		System.out.println("바뀐 비번 암호화:" + encpassword);
		user.setUser_pw(encpassword);

		result = service.updatePwd(user);
		
		if (result == 1) {
			User db = service.selectUser(user.getUser_id());
			Map map = new HashMap<>();
			map.put("db", db);

			return new ResponseEntity<>(map, HttpStatus.OK);
		} else {
			System.out.println("에러");
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}


}
