package com.yedam.app.common.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.emp.service.EmpVO;

@CrossOrigin(origins = "*") // cors 설정
@Controller
public class ParameterController {
	// QueryString(질의문자열) : key=value&key=value&...
	// Content-type : application/x-www-form-urlencode
	// Method : 상관없음

	// QueryString, 1) 커맨드 객체 (어노테이션 X, 객체)
	@RequestMapping("comobj")
	@ResponseBody // AJAX
	public String commandObject(EmpVO empVO) {
		String result = "";
		result += "Path : /comobj \n";
		result += "\t employee_id : " + empVO.getEmployeeId();
		result += "\t last_name : " + empVO.getLastName();
		return result;
	}

	// QueryString, 2) @RequestParam (기본타입, 단일값)
	@RequestMapping("reqparm")
	@ResponseBody
	public String requestParam(@RequestParam Integer employeeId, String lastName) {
		String result = "";
		result += "path : /reqparm \n";
		result += "\t employee_id : " + employeeId;
		result += "\t last_name : " + lastName;
		return result;
	}

	// Method는 상관없음
	// Content-type도 상관없음
	@RequestMapping("path/{id}") // path/Hong, path/1234
	@ResponseBody
	public String pathVariable(@PathVariable String id) {
		String result = "";
		result += "path : /path/{id} \n";
		result += "\t id : " + id;
		return result;
	}

	// @RequestBody : JSON 포맷, 배열 OR 객체
	// Method : POST, PUT
	// Content-type : application/json
	@PostMapping("resbodyList")
	@ResponseBody
	public List<EmpVO> requestBodyList(@RequestBody List<EmpVO> list) {
		return list;
	}
}
