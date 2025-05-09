<template>
  


    <div class="job-list-container">
    <router-link to="/add-job">
  <button>Add a job</button>
</router-link>
    <h2>My Jobs</h2>
    <div class="job-card" v-for="job in jobs" :key="job.id">
      <p class="job-name">{{ job.name }}</p>
      <p class="job-service">Service: {{ job.title }}</p>
      <p class="job-date">Date: {{ job.jobDate }}</p>
    </div>
  </div>



</template>

<script>
import JobService from '../services/JobService';
export default {
    data() {
        return {
            jobs: []
        }
    },

    created() {
        JobService.getJobs()
            .then(response => {
                this.jobs = response.data;
            })
            .catch(error => {
                console.error("There was an error fetching the jobs!", error);
            });
    },

}
</script>


<style lang="scss" scoped>
@import "@/styles/jobs.scss";
</style>