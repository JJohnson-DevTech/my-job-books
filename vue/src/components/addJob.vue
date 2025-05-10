<template>
    <div>
      <form @submit.prevent="addJob">
        <div class="form-group">
          <label for="jobTitle">Job Title:</label>
          <input v-model="job.title" id="jobTitle" type="text" required placeholder="Enter job title" />
        </div>

        <br>


        <div class="form-group">
          <label for="jobName">Name:</label>
          <input v-model="job.name" id="jobName" type="text" required placeholder="Enter customers name" />
        </div>
   <br>
        <div class="form-group">
          <label for="email">Email:</label>
          <input v-model="job.email" id="email" type="email" required placeholder="Enter customers email" />
        </div>
        <br>
        <div class="form-group">
          <label for="number">Phone Number:</label>
          <input v-model="job.number" id="number" type="tel" placeholder="Enter customers number" />
        </div>
        <br>
        <div class="form-group">
          <label for="location">Job Location:</label>
          <input v-model="job.location" id="location" type="text" required placeholder="Enter job location" />
        </div>
        <br>
        <div class="form-group">
          <label for="jobDate">Job Date:</label>
          <input v-model="job.jobDate" id="jobDate" type="datetime-local" required />
        </div>
        <br>
        <div class="form-group">
          <label for="materialCost">Material Cost:</label>
          <input v-model="job.materialCost" id="materialCost" type="number" step="0.01" required placeholder="Enter material cost" />
        </div>
        <br>
        <div class="form-group">
          <label for="price">Job Price:</label>
          <input v-model="job.price" id="price" type="number" step="0.01" required placeholder="Enter job price" />
        </div>
        <br>
        <div class="button-container">
          <button type="submit" class="submit-btn">Save Job</button>
          <button type="button" class="back-btn" @click="goBack">Go Back</button>
        </div>
      </form>
    </div>
  </template>
  
  
  
  <script>
 import JobService from '../services/JobService';
  
  export default {
    data() {
      return {
        job: {
          title: "",
          name: "",
          email: '',
          number: '',
          location: '',
          jobDate: '',
          materialCost: '',
          price : '',
          userId: '',
        },
      };
    },
    created() {
    //   this.curriculum.courseId = this.$route.params.id; // Retrieve courseId from route
      const username = this.$store.state.user.username;
      if (username) {
        JobService.getUserId(username).then(response => {
          this.job.userId = response.data;
        });
      }
    },
    methods: {
      addJob() {
        JobService.createJob(this.job).then(
          (response) => {
           
              this.$router.push( {name: 'home'} );
            
          }
        );
      },
      goBack() {
        this.$router.push({ name: 'home' });
      }
    }
  };
  </script>
    
  <style scoped>
 
  </style>