package PhoneBook;

import java.util.List;

public interface PhoneDAO {
		public List<PhoneVO> getList();
		public List<PhoneVO> search(String keyword);
		public boolean insert(PhoneVO vo);
		public boolean insertphone(PhoneVO vo);
		public boolean delete(Long id);
	}

