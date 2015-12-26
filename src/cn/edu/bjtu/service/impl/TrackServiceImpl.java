package cn.edu.bjtu.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.bjtu.dao.TrackDao;
import cn.edu.bjtu.service.TrackService;
import cn.edu.bjtu.vo.Track;

@Transactional
@Repository
public class TrackServiceImpl implements TrackService {
	
	@Resource
	TrackDao trackDao;

	@Override
	public boolean createNewTrack(String id, String orderId, String carNum, Double locLongitude, Double locLatitude,
			Date time, String address) {
		// TODO �Զ����ɵķ������
		return trackDao.createNewTrack(id, orderId, carNum, locLongitude, locLatitude, time, address);
	}

	@Override
	public List<Track> getTrackByOrderId(String orderId) {
		// TODO �Զ����ɵķ������
		return trackDao.getTrackByOrderId(orderId);
	}
	
}
