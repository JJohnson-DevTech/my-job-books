import axios from 'axios';

const http = axios.create({
  baseURL: import.meta.env.VITE_REMOTE_API
});

export default {

  createJob(jobObject) {
    return axios.post('/create-job', jobObject)
  },
  editJob(jobObject) {
    return axios.put('/edit-job', jobObject)
  },


  getJobs() {
    return axios.get("/get-jobs");
},
getUserId(username) {
    return axios.get(`/get-user-id/${username}`);
  },
  getJobById(jobId) {
    return axios.get(`/get-job/${jobId}`);
  },

}
