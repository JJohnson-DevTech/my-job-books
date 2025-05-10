<template>
  <div>
    <form @submit.prevent="editJob">
      <div class="form-group">
        <label for="jobTitle">Job Title:</label>
        <input v-model="job.title" id="jobTitle" type="text" required />
      </div>
      <br>

      <div class="form-group">
        <label for="jobName">Name:</label>
        <input v-model="job.name" id="jobName" type="text" required />
      </div>
      <br>

      <div class="form-group">
        <label for="email">Email:</label>
        <input v-model="job.email" id="email" type="email" required />
      </div>
      <br>

      <div class="form-group">
        <label for="number">Phone Number:</label>
        <input v-model="job.number" id="number" type="tel" />
      </div>
      <br>

      <div class="form-group">
        <label for="location">Job Location:</label>
        <input v-model="job.location" id="location" type="text" required />
      </div>
      <br>

      <div class="form-group">
        <label for="jobDate">Job Date:</label>
        <input v-model="job.jobDate" id="jobDate" type="datetime-local" required />
      </div>
      <br>

      <div class="form-group">
        <label for="materialCost">Material Cost:</label>
        <input v-model="job.materialCost" id="materialCost" type="number" step="0.01" required />
      </div>
      <br>

      <div class="form-group">
        <label for="price">Job Price:</label>
        <input v-model="job.price" id="price" type="number" step="0.01" required />
      </div>
      <br>

      <div class="button-container">
        <button type="submit" class="submit-btn">Update Job</button>
        <button type="button" class="back-btn" @click="goBack">Cancel</button>
      </div>
    </form>
  </div>
</template>

<script>

import JobService from '../services/JobService';
export default {
 data() {
   return {
       jobId : -1,
       job: {}
   };
 },
 created() {
  this.jobId = this.$route.params.id;

  JobService.getJobById(this.jobId).then((response) => {
    this.job = response.data;

    // Make sure jobDate is in datetime-local format (e.g., 2025-05-10T15:00)
    this.job.jobDate = new Date(this.job.jobDate).toISOString().slice(0, 16);
  });
},
 methods: {
   editJob() {
     JobService.editJob(this.job)
       .then((response) => {
          
           this.$router.push('/');
         
       })
       .catch((error) => {
         console.error("Error updating course:", error);
       })
       
   },
   
 }
};
</script>

<style scoped>

</style>