# Containers

## What are containers?

Containers are a form of operating system virtualization: They allow you to package and isolate an application with all of its dependencies (libraries, frameworks, configuration files, etc.) into a single, versioned package or 'container'. A container is in fact an assembly ("union") of multiple *partial filesystems*.

Unlike traditional virtual machines (more on these later in the course) that require their own full-blown operating system, containers share the host system's OS kernel, but run in isolated user spaces. This makes them more lightweight and faster to start than virtual machines. Perhaps surprisingly, x86 Linux containers can actually be run on any standard operating system, on any of the common processor architectures.

## Why use containers?

- **Standardized Deployment**: No matter where the container runs - be it on your local machine, a colleague's computer, or a cloud environment - it will behave the same way.
- **Version Control and Reuse**: Containers can be version controlled, just like source code. This means you can track changes, rollback to previous versions, and ensure consistency across different environments. They also promote reuse. You can use existing containers as base images to build upon, saving time and effort.
- **Deployment on Cloud**: Containers are ideal for cloud deployment. They can be easily moved across different cloud environments, for example, between AWS, Azure, Google Cloud, etc.
- **Scalability and Resource Efficiency**: Due to their lightweight nature, you can run many containers on a single machine, optimizing resource use. They are easily scalable; you can quickly spin up new instances of a container to handle increased load.
- **Isolation and Security**: Each container is isolated from others and the host system, providing a level of security. If one container is compromised, others remain unaffected.
- **DevOps and Continuous Integration/Continuous Deployment (CI/CD)**: Containers fit well into CI/CD pipelines. They can be created automatically as part of the build process, used for testing, and then deployed to production, streamlining the entire lifecycle of an application.

# What is Docker?

Docker is a popular tool that simplifies the process of creating, deploying, and running applications using containers. It packages applications and their dependencies into containers, which are running instances of images.

**Docker images** are the compiled contents (program binaries, data, etc.), assembled from "blueprints" for containers. More specifically, they assembled based on the blueprints in *Dockerfiles*. They can be stored and distributed via Docker registries such as Docker Hub or Amazon Elastic Container Registry. Once an image is created, it doesn't change and lasts until you explicitly delete it.

By default, any data created inside a container is considered temporary and lost when the container is destroyed. However, Docker provides **Docker volumes** to persist data independent of the container's lifecycle. The data in volumes is not removed when the container is removed and lasts until you explicitly delete the volume. Volumes can be shared and reused among multiple containers, which is useful for updating containers or sharing data between containers.

Docker containers interact with the external world (specifically, their "host computer") in two key ways.

* **Virtual ports** in Docker are a part of its networking features. Ports are how machines talk to each other on the Internet. Virtual ports allow you to connect a port on your machine (aka "localhost") to a port on the Docker container. This is crucial for accessing applications running inside containers from outside the Docker host.  A Docker virtual port lets you link the container's port (say, for a web server) to your "host" network, so you can access it from a web browser on the host machine.  We will be using virtual ports to allow your local web browser to connect to server software running in the container.
* Additionally, Docker supports **bind mounts** that allow it to have access to directories on the host machine's filesystem, thus enabling sharing between the container and host operating systems. We will be using bind mounts to share certain directories between your host computer and your container.

