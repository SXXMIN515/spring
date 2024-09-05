package com.yedam.app.dept.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.dept.mapper.DeptMapper;
@Service
public class DeptServiceImpl implements DeptService {
	private DeptMapper deptMapper;
	
	@Autowired
	DeptServiceImpl(DeptMapper deptMapper) {
		this.deptMapper = deptMapper;
	}

	@Override
	public List<DeptVO> deptList() {
		return deptMapper.selectDeptAll();
	}

	@Override
	public DeptVO deptInfo(DeptVO deptVO) {
		return deptMapper.selectDeptInfo(deptVO);
	}

	@Override
	public int deptInsert(DeptVO deptVO) {
		int result = deptMapper.insertDeptInfo(deptVO);
		return result == 1 ? deptVO.getDepartmentId() : -1;
	}

	@Override
	public Map<String, Object> deptUpdate(DeptVO deptVO) {
		Map<String, Object> map = new HashMap<>();
		boolean isSuccessed = false;
		
		int result 
		= deptMapper.updateDeptInfo(deptVO.getDepartmentId(), deptVO);
		
		if(result == 1) {
			isSuccessed = true;
		}
		
		map.put("result", isSuccessed);
		map.put("target", deptVO);
		return map;
	}

	@Override
	public Map<String, Object> deptDelete(int departmentId) {
		Map<String, Object> map = new HashMap<>();
		// 삭제가 안될 경우 : {}
		// 삭제가 될 경우  : { "employeeId" : 104 }
		int result = deptMapper.deleteDeptInfo(departmentId);
		
		if(result == 1) {
			map.put("departmentId", departmentId);
		}
		
		return map;
	}
	
	
}
