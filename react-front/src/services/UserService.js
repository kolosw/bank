import CrudService from './CrudService';

export class UserService extends CrudService {
  constructor() {
    super('/users');
  }
}
