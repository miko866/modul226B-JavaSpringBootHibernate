<template>
  <div class="dashboard">
    <!-- START Header -->
    <v-layout row wrap>
      <v-flex d-flex sm6 md8 lg10 xl10 justify-center ma-auto>
        <h1 class="display-1 pt-3 pb-5">All Clients</h1>
      </v-flex>
    </v-layout>
    <!-- END Header -->

    <v-layout row wrap class="pt-3">
      <v-flex d-flex sm10 md10 lg10 xl10 justify-center ma-auto>
        <!-- START Table -->
        <v-data-table
          ref="table"
          :headers="headers"
          :items="clients"
          :search="search"
          class="elevation-1 custom-width"
        >
          <template v-slot:top>
            <v-toolbar flat color="white">
              <!-- START Searchbar -->
              <v-text-field
                v-model="search"
                append-icon="search"
                label="Search"
                single-line
                hide-details
              ></v-text-field>
              <!-- END Searchbar -->
              <v-spacer></v-spacer>
              <!-- START Dialog create btn -->
              <v-btn color="primary" dark class="mb-2" @click="dialog = true">Create New</v-btn>
              <!-- END Dialog create btn -->
              <!-- START Dialog  -->
              <v-dialog v-model="dialog" max-width="500px">
                <v-card>
                  <v-card-title>
                    <span class="headline">{{ formTitle }}</span>
                  </v-card-title>

                  <v-card-text>
                    <v-container>
                      <v-row>
                        <v-col cols="12" sm="12" md="12">
                          <v-text-field
                            v-model.trim="firstName"
                            :value="firstName"
                            label="First Name"
                          ></v-text-field>
                        </v-col>
                        <v-col cols="12" sm="12" md="12">
                          <v-text-field
                            v-model.trim="lastName"
                            :value="lastName"
                            label="Last Name"
                          ></v-text-field>
                        </v-col>

                        <v-col cols="12" sm="12" md="12">
                          <v-text-field
                            v-model.trim="company"
                            :value="company"
                            label="Company"
                          ></v-text-field>
                        </v-col>
                      </v-row>
                    </v-container>
                  </v-card-text>

                  <v-card-actions>
                    <v-spacer></v-spacer>
                    <v-btn color="blue darken-1" text @click="close">Cancel</v-btn>
                    <v-btn color="blue darken-1" text @click="save">Save</v-btn>
                  </v-card-actions>
                </v-card>
              </v-dialog>
              <!-- END Dialog -->
            </v-toolbar>
          </template>
          <template v-slot:body="{ items }">
            <tbody>
              <tr v-for="item in items" :key="item.id">
                <td>{{ item.first_name }}</td>
                <td>{{ item.last_name }}</td>
                <td>{{ item.company }}</td>
                <td>{{ item.created }}</td>
                <td>
                  <v-icon
                    small
                    @click="clientContact(item)"
                    color="blue darken-2"
                    class="mr-2 custom-hover__button"
                    >perm_contact_calendar
                  </v-icon>
                  <v-icon small class="mr-2 custom-hover__button" @click="editItem(item)">
                    edit
                  </v-icon>
                  <v-icon
                    small
                    @click="deleteItem(item)"
                    color="blue darken-2"
                    class="custom-hover__button"
                    >delete
                  </v-icon>
                </td>
              </tr>
            </tbody>
          </template>
          <template v-slot:no-data>
            <v-btn color="primary" @click="initialize">Och NOOO any Data</v-btn>
          </template>
        </v-data-table>
        <!-- END Table -->
      </v-flex>
    </v-layout>
  </div>
</template>

<script>
//* For Rest API
import axios from 'axios';

import { sanitize, capitalize } from '@/helpers.js';

export default {
  name: 'dashboard',
  data: () => ({
    search: '',
    dialog: false,
    clients: [],
    headers: [
      {
        text: 'First Name',
        align: 'left',
        value: 'first_name',
        sortable: true
      },
      { text: 'Last Name', value: 'last_name', sortable: true, align: 'left' },
      { text: 'Company', value: 'company', sortable: true, align: 'left' },
      { text: 'Created', value: 'created', sortable: true, align: 'left' },
      { text: 'Actions', value: 'action', sortable: false, align: 'left' }
    ],
    editedIndex: -1,

    firstName: '',
    lastName: '',
    company: '',
    created: '',
    editedItemId: null
  }),

  computed: {
    formTitle() {
      return this.editedIndex === -1 ? 'New Customer' : 'Edit Customer';
    }
  },

  watch: {
    dialog(val) {
      val || this.close();
    },
    clients(val) {
      console.log('Clients', val);
    }
  },

  methods: {
    clientContact(item) {
      this.$store.dispatch('setClientID', item.id);
      this.$store.dispatch('setClientFirstName', item.first_name);
      this.$store.dispatch('setClientLastName', item.last_name);

      this.$router.push({ name: 'client' });
    },
    checkStateId() {
      this.state = this.canton.id;
    },

    checkRole() {
      if (this.role === 'admin') {
        this.roleId = 1;
      } else {
        this.roleId = 2;
      }
    },

    editItem(item) {
      this.editedIndex = item.id;

      this.firstName = item.first_name;
      this.lastName = item.last_name;
      this.company = item.company;

      this.editedItemId = item.id;

      this.dialog = true;
    },

    deleteItem(item) {
      let timerInterval;
      this.$swal({
        backdrop: false,
        title: 'Remove Customer',
        text: 'Are you  sure ?',
        type: 'warning',
        width: 400,
        showCancelButton: true,
        confirmButtonColor: '#a8b6bb',
        cancelButtonColor: 'white',
        confirmButtonText: 'Confirm',
        cancelButtonText: 'Cancel'
      }).then(result => {
        if (result.value) {
          axios
            .post(`http://localhost:8080/client/deletClient/${item.id}`, {
              headers: { 'Content-Type': 'multipart/form-data' }
            })
            .then(response => {
              console.log('Delete', response);
            })
            .catch(() => {
              console.log('error');
            });

          this.$swal.fire({
            backdrop: false,
            title: 'Removed',
            type: 'success',
            showConfirmButton: false,
            timer: 3000,
            onClose: () => {
              clearInterval(timerInterval);
              location.reload();
            }
          });
        }
      });

      // setTimeout(
      //   function() {
      //     this.refetch();
      //   }.bind(this),
      //   500
      // );
    },

    close() {
      this.dialog = false;
    },

    save() {
      let datetime = new Date();
      let time = datetime.toISOString().slice(0, 10);
      let timeArray = time.split('-');
      let day = timeArray[2];
      let month = timeArray[1];
      let year = timeArray[0];
      let newTimeArray = [day, month, year];
      let timeToString = newTimeArray.join('.');

      if (this.editedIndex === -1) {
        let formDataClient = new FormData();
        formDataClient.append('first_name', sanitize(capitalize(this.firstName)));
        formDataClient.append('last_name', sanitize(capitalize(this.lastName)));
        formDataClient.append('company', sanitize(capitalize(this.company)));
        formDataClient.append('created', timeToString);

        axios
          .post('http://localhost:8080/client/saveClient', formDataClient, {
            headers: { 'Content-Type': 'multipart/form-data' }
          })
          .then(response => {
            console.log(response);
            location.reload();
          })
          .catch(() => {
            console.log('error');
          });
      } else {
        let formDataClient = new FormData();
        formDataClient.append('id', this.editedItemId);
        formDataClient.append('first_name', sanitize(capitalize(this.firstName)));
        formDataClient.append('last_name', sanitize(capitalize(this.lastName)));
        formDataClient.append('company', sanitize(capitalize(this.company)));
        formDataClient.append('created', timeToString);

        axios
          .post('http://localhost:8080/client/saveClient', formDataClient, {
            headers: { 'Content-Type': 'multipart/form-data' }
          })
          .then(response => {
            console.log(response);
            location.reload();
          })
          .catch(() => {
            console.log('error');
          });
      }

      this.editedIndex = -1;
      this.first_name = '';
      this.last_name = '';
      this.company = '';

      this.close();
    }
  },
  created() {
    axios
      .get('http://localhost:8080/client/allClients')
      .then(response => {
        this.clients = response.data;
        console.log('CUSTOmer', this.clients);
      })
      .catch(function(error) {
        // handle error
        console.log(error);
      });
  }
  // updated: function() {
  //   console.log('Updated', this.$refs['table']);
  //   //Msg is updated
  // }
};
</script>

<style lang="scss">
@import '../assets/styles/sweetAlert.scss';

.custom-width {
  width: 100%;
}
</style>
