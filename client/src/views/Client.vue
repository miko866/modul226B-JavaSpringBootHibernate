<template>
  <div class="client">
    <!-- START Address -->
    <v-layout row wrap>
      <!-- START Address header -->
      <v-flex d-flex sm6 md8 lg10 xl10 justify-center ma-auto>
        <h1 class="display-1 pt-3 pb-5">{{ firstName + ' ' + lastName }} Address</h1>
      </v-flex>
      <!-- END Address header -->
    </v-layout>

    <v-layout row wrap class="pt-3 pb-5">
      <v-flex d-flex sm10 md10 lg10 xl10 justify-center ma-auto>
        <!-- START Address Table -->
        <v-data-table
          :headers="headersAddress"
          :items="address"
          :search="searchAddress"
          class="elevation-1 custom-width"
        >
          <template v-slot:top>
            <v-toolbar flat color="white">
              <!-- Start Address Search Bar -->
              <v-text-field
                v-model="searchAddress"
                append-icon="search"
                label="Search"
                single-line
                hide-details
              ></v-text-field>
              <!-- END Address Search Bar -->

              <v-spacer></v-spacer>
              <!-- START Address Dialog -->
              <v-dialog v-model="dialogAddress" max-width="500px">
                <!-- START Address Create btn -->
                <template v-slot:activator="{ on }">
                  <v-btn color="primary" dark class="mb-2" v-on="on">Create New</v-btn>
                </template>
                <!-- END Address Create btn -->
                <v-card>
                  <v-card-title>
                    <span class="headline">{{ formTitleAddress }}</span>
                  </v-card-title>

                  <!-- START Address Dialog content -->
                  <v-card-text>
                    <v-container>
                      <v-row>
                        <v-col cols="12" sm="12" md="12">
                          <v-text-field
                            v-model.trim="street"
                            :value="street"
                            label="Street"
                          ></v-text-field>
                        </v-col>

                        <v-col cols="12" sm="12" md="12">
                          <v-text-field
                            v-model.trim="streetNumber"
                            :value="streetNumber"
                            label="Street Number"
                          ></v-text-field>
                        </v-col>

                        <v-col cols="12" sm="12" md="12">
                          <v-text-field
                            v-model.trim="zip"
                            type="number"
                            :value="zip"
                            label="Zip"
                          ></v-text-field>
                        </v-col>

                        <v-col cols="12" sm="12" md="12">
                          <v-text-field
                            v-model.trim="city"
                            :value="city"
                            label="City"
                          ></v-text-field>
                        </v-col>
                      </v-row>
                    </v-container>
                  </v-card-text>
                  <!-- END Address Dialog Content-->
                  <v-card-actions>
                    <v-spacer></v-spacer>
                    <!-- START Address Dialog btns  -->
                    <v-btn color="blue darken-1" text @click="closeAddress">Cancel</v-btn>
                    <v-btn color="blue darken-1" text @click="saveAddress">Save</v-btn>
                    <!-- END Address Dialog btns -->
                  </v-card-actions>
                </v-card>
              </v-dialog>
              <!-- END Address Dialog -->
            </v-toolbar>
          </template>
          <!-- START Address Table body -->
          <template v-slot:body="{ items }">
            <tbody>
              <tr v-for="item in items" :key="item.id">
                <td>{{ item.street }}</td>
                <td>{{ item.street_number }}</td>
                <td>{{ item.zip }}</td>
                <td>{{ item.city }}</td>
                <td>
                  <v-icon small class="mr-2 custom-hover__button" @click="editItemAddress(item)">
                    edit
                  </v-icon>
                  <v-icon
                    small
                    @click="deleteItemAddress(item)"
                    color="blue darken-2"
                    class="custom-hover__button"
                    >delete
                  </v-icon>
                </td>
              </tr>
            </tbody>
          </template>
          <!-- END Address Table body-->
          <template v-slot:no-data>
            <v-btn color="primary" @click="initialize">Och NOOO any Data</v-btn>
          </template>
        </v-data-table>
        <!-- END Address Table -->
      </v-flex>
    </v-layout>
    <!-- END Address -->

    <!-- START Contact header -->
    <v-layout row wrap pt-5>
      <v-flex d-flex sm6 md8 lg10 xl10 justify-center ma-auto>
        <h1 class="display-1 pt-3 pb-5">{{ firstName + ' ' + lastName }} Contact</h1>
      </v-flex>
    </v-layout>
    <!-- END Contact header -->

    <v-layout row wrap class="pt-3 pb-5">
      <v-flex d-flex sm10 md10 lg10 xl10 justify-center ma-auto>
        <!-- START Contact Table -->
        <v-data-table
          :headers="headersContact"
          :items="contacts"
          :search="searchContact"
          class="elevation-1 custom-width"
        >
          <template v-slot:top>
            <v-toolbar flat color="white">
              <!-- Start Contact Search Bar -->
              <v-text-field
                v-model="searchContact"
                append-icon="search"
                label="Search"
                single-line
                hide-details
              ></v-text-field>
              <!-- END Contact Search Bar -->
              <v-spacer></v-spacer>
              <!-- START Contact Dialog -->
              <v-dialog v-model="dialogContact" max-width="500px">
                <!-- START Contact Create btn -->
                <template v-slot:activator="{ on }">
                  <v-btn color="primary" dark class="mb-2" v-on="on">Create New</v-btn>
                </template>
                <!-- END Contact Create btn -->
                <v-card>
                  <v-card-title>
                    <span class="headline">{{ formTitleContact }}</span>
                  </v-card-title>

                  <!-- START Contact Dialog content -->
                  <v-card-text>
                    <v-container>
                      <v-row>
                        <v-col cols="12" sm="12" md="12">
                          <v-text-field
                            v-model.trim="name"
                            :value="name"
                            label="Name"
                          ></v-text-field>
                        </v-col>

                        <v-col cols="12" sm="12" md="12">
                          <v-select
                            :items="typeSelect"
                            label="Type"
                            return-object
                            v-model="type"
                          ></v-select>
                        </v-col>

                        <v-col cols="12" sm="12" md="12">
                          <v-select
                            :items="sortSelect"
                            label="Sort"
                            return-object
                            v-model="sort"
                          ></v-select>
                        </v-col>

                        <v-col cols="12" sm="12" md="12">
                          <v-text-field
                            v-model.trim="value"
                            :value="value"
                            label="Value"
                          ></v-text-field>
                        </v-col>
                      </v-row>
                    </v-container>
                  </v-card-text>
                  <!-- END Contact Dialog content -->

                  <v-card-actions>
                    <v-spacer></v-spacer>
                    <!-- START Contact Dialog btns  -->
                    <v-btn color="blue darken-1" text @click="closeContact">Cancel</v-btn>
                    <v-btn color="blue darken-1" text @click="saveContact">Save</v-btn>
                    <!-- END Contact Dialog btns  -->
                  </v-card-actions>
                </v-card>
              </v-dialog>
              <!-- END START Contact Dialog -->
            </v-toolbar>
          </template>
          <!-- START Contact Table body -->
          <template v-slot:body="{ items }">
            <tbody>
              <tr v-for="item in items" :key="item.id">
                <td>{{ item.name }}</td>
                <td>{{ item.type }}</td>
                <td>{{ item.sort }}</td>
                <td>{{ item.value }}</td>
                <td>
                  <v-icon small class="mr-2 custom-hover__button" @click="editItemContact(item)">
                    edit
                  </v-icon>
                  <v-icon
                    small
                    @click="deleteItemContact(item)"
                    color="blue darken-2"
                    class="custom-hover__button"
                    >delete
                  </v-icon>
                </td>
              </tr>
            </tbody>
          </template>
          <!-- END Contact Table body -->
          <template v-slot:no-data>
            <v-btn color="primary" @click="initialize">Och NOOO any Data</v-btn>
          </template>
        </v-data-table>
        <!-- END Contact Table -->
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
    clientID: null,
    searchAddress: '',
    searchContact: '',
    dialogAddress: false,
    dialogContact: false,
    address: [],
    contacts: [],
    headersAddress: [
      { text: 'Street', value: 'street', sortable: true, align: 'left' },
      { text: 'Street Number', value: 'street_number', sortable: true, align: 'left' },
      { text: 'Zip', value: 'zip', sortable: true, align: 'left' },
      {
        text: 'City',
        align: 'left',
        value: 'city',
        sortable: true
      },
      { text: 'Actions', value: 'action', sortable: false, align: 'left' }
    ],
    headersContact: [
      {
        text: 'Name',
        align: 'left',
        value: 'name',
        sortable: true
      },
      { text: 'Type', value: 'type', sortable: true, align: 'left' },
      { text: 'Sort', value: 'sort', sortable: true, align: 'left' },
      { text: 'Value', value: 'value', sortable: true, align: 'left' },
      { text: 'Actions', value: 'action', sortable: false, align: 'left' }
    ],
    editedIndexAddress: -1,
    editedIndexContact: -1,

    city: '',
    street: '',
    streetNumber: '',
    zip: null,
    name: '',
    type: '',
    typeSelect: ['Email', 'Phone', 'Facebook', 'Instagram'],
    sortSelect: ['Private', 'Work', 'Gandalf'],
    sort: '',
    value: '',
    editedItemAddressId: null,
    editedItemContactId: null
  }),

  computed: {
    formTitleAddress() {
      return this.editedIndexAddress === -1 ? 'New Address' : 'Edit Address';
    },
    formTitleContact() {
      return this.editedIndexContact === -1 ? 'New Contact' : 'Edit Contact';
    }
  },

  watch: {
    dialogAddress(val) {
      val || this.closeAddress();
    },
    dialogContact(val) {
      val || this.closeContact();
    }
  },

  methods: {
    editItemAddress(item) {
      this.editedIndexAddress = item.id;

      this.street = item.street;
      this.streetNumber = item.street_number;
      this.zip = item.zip;
      this.city = item.city;

      this.editedItemAddressId = item.id;

      this.dialogAddress = true;
    },

    editItemContact(item) {
      this.editedIndexContact = item.id;

      this.name = item.name;
      this.type = item.type;
      this.sort = item.sort;
      this.value = item.value;

      this.editedItemContactId = item.id;

      this.dialogContact = true;
    },

    deleteItemAddress(item) {
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
            .post(`http://localhost:8080/client/deleteAddress/${item.id}`, {
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
    },

    deleteItemContact(item) {
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
            .post(`http://localhost:8080/client/deleteContact/${item.id}`, {
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
    },

    closeAddress() {
      this.dialogAddress = false;
    },
    closeContact() {
      this.dialogContact = false;
    },

    saveAddress() {
      this.clientID = this.$store.state.clientID;

      if (this.editedIndexAddress === -1) {
        let formDataAddress = new FormData();
        formDataAddress.append('street', sanitize(capitalize(this.street)));
        formDataAddress.append('street_number', sanitize(capitalize(this.streetNumber)));
        formDataAddress.append('zip', this.zip);
        formDataAddress.append('city', sanitize(capitalize(this.city)));
        formDataAddress.append('client_id', this.clientID);

        axios
          .post('http://localhost:8080/client/saveAddress', formDataAddress, {
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
        let formDataAddress = new FormData();
        formDataAddress.append('id', this.editedItemAddressId);
        formDataAddress.append('street', sanitize(capitalize(this.street)));
        formDataAddress.append('street_number', sanitize(capitalize(this.streetNumber)));
        formDataAddress.append('zip', this.zip);
        formDataAddress.append('city', sanitize(capitalize(this.city)));
        formDataAddress.append('client_id', this.clientID);

        axios
          .post('http://localhost:8080/client/saveAddress', formDataAddress, {
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

      this.editedIndexAddress = -1;
      this.street = '';
      this.streetNumber = '';
      this.zip = null;
      this.city = '';

      this.closeAddress();
    },
    saveContact() {
      this.clientID = this.$store.state.clientID;

      if (this.editedIndexContact === -1) {
        let formDataContact = new FormData();
        formDataContact.append('name', sanitize(capitalize(this.name)));
        formDataContact.append('type', this.type);
        formDataContact.append('sort', this.sort);
        formDataContact.append('value', sanitize(capitalize(this.value)));
        formDataContact.append('client_id', this.clientID);

        axios
          .post('http://localhost:8080/client/saveContact', formDataContact, {
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
        let formDataContact = new FormData();

        formDataContact.append('id', this.editedItemContactId);
        formDataContact.append('name', sanitize(capitalize(this.name)));
        formDataContact.append('type', this.type);
        formDataContact.append('sort', this.sort);
        formDataContact.append('value', sanitize(capitalize(this.value)));
        formDataContact.append('client_id', this.clientID);

        axios
          .post('http://localhost:8080/client/saveContact', formDataContact, {
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

      this.close();
    }
  },
  created() {
    let clientID = this.$store.state.clientID;
    this.firstName = this.$store.state.clientFirstName;
    this.lastName = this.$store.state.clientLastName;

    axios
      .get(`http://localhost:8080/client/addressClient/${clientID}`)
      .then(response => {
        this.address = response.data;
        console.log('Address::', this.address);
      })
      .catch(function(error) {
        // handle error
        console.log(error);
      });

    axios
      .get(`http://localhost:8080/client/contactClient/${clientID}`)
      .then(response => {
        this.contacts = response.data;
        console.log('Contacts::', this.contacts);
      })
      .catch(function(error) {
        // handle error
        console.log(error);
      });
  }
};
</script>

<style lang="scss">
@import '../assets/styles/sweetAlert.scss';

.custom-width {
  width: 100%;
}
</style>
