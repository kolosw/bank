import axios from 'axios';

class CrudService {
  constructor(apiUrl) {
    this.apiUrl = '/api'+apiUrl;
  }

  async getAll() {
    const response = await axios.get(this.apiUrl);
    return response;
  }

  async getById(id) {
    const response = await axios.get(`${this.apiUrl}/${id}`);
    return response;
  }

  async create(newData) {
    const response = await axios.post(this.apiUrl, newData);
    return response;
  }

  async update(id, updatedData) {
    const response = await axios.put(`${this.apiUrl}/${id}`, updatedData);
    return response;
  }

  async delete(id) {
    const response = await axios.delete(`${this.apiUrl}/${id}`);
    return response; // Assuming a successful delete returns a 204 status
  }
}

export default CrudService;