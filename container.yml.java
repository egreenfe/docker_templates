version: '2'
settings:

  conductor:
    # The Conductor container does the heavy lifting, and provides a portable
    # Python runtime for building your target containers. It should be derived
    # from the same distribution as you're building your target containers with.
    base: "{{ var_base_image }}"
  roles_path: "/home/docker/.ansible"  
    # volumes:      # Provide a list of volumes to mount
    # environment:  # List or mapping of environment variables

  # Set the name of the project. Defaults to basename of the project directory.
  # For built services, concatenated with service name to form the built image name.

services:
  # Add your containers here, specifying the base image you want to build from.
  # To use this example, uncomment it and delete the curly braces after services key.

  apiserver:
    from: "{{ service_image }}"
    roles:
     - ansible-role-repoepel
     - ansible-role-sbootsvr
     - ansible-role-java
    expose:
     - "{{ var_service_expose_port }}"
    command: ['/usr/bin/java','-jar',"{{ var_java_archive_file }}"]
