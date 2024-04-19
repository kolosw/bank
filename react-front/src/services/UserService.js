import CrudService from './CrudService';

class UserService extends CrudService {
  constructor() {
    super('/users');
  }
}

export default UserService;