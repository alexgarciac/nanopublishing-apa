--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: annotation; Type: TABLE; Schema: public; Owner: nanotate; Tablespace: 
--

CREATE TABLE annotation (
    original_text character varying,
    tags character varying,
    document character varying,
    status character varying,
    creation timestamp with time zone,
    completed timestamp with time zone,
    id integer NOT NULL,
    json_value text,
    doi character varying,
    user_name character varying
);


ALTER TABLE public.annotation OWNER TO nanotate;

--
-- Name: annotation_id_seq; Type: SEQUENCE; Schema: public; Owner: nanotate
--

CREATE SEQUENCE annotation_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.annotation_id_seq OWNER TO nanotate;

--
-- Name: annotation_user_name_seq; Type: SEQUENCE; Schema: public; Owner: nanotate
--

CREATE SEQUENCE annotation_user_name_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.annotation_user_name_seq OWNER TO nanotate;

--
-- Name: annotation_user_name_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: nanotate
--

ALTER SEQUENCE annotation_user_name_seq OWNED BY annotation.user_name;


--
-- Name: document; Type: TABLE; Schema: public; Owner: nanotate; Tablespace: 
--

CREATE TABLE document (
    uuid character varying NOT NULL,
    doi character varying,
    title character varying,
    full_citation character varying,
    year integer
);


ALTER TABLE public.document OWNER TO nanotate;

--
-- Name: user; Type: TABLE; Schema: public; Owner: nanotate; Tablespace: 
--

CREATE TABLE "user" (
    username character varying NOT NULL,
    password character varying,
    twitter_username character varying,
    facebook_username character varying,
    firstname character varying,
    lastname character varying,
    facebook_token character varying,
    twitter_token character varying
);


ALTER TABLE public."user" OWNER TO nanotate;

--
-- Data for Name: annotation; Type: TABLE DATA; Schema: public; Owner: nanotate
--

INSERT INTO annotation VALUES ('Psychophysiologic Reactivity, Subjective Distress, and Their Associations
With PTSD Diagnosis', 'DISTRESS,PTSD,DIAGNOSIS', '5d965ff2-b7d0-4025-b36e-e611d500b62d', 'COMPLETED', '2014-05-23 15:04:41.864-05', '2014-05-23 15:04:42.58-05', 50, '[{"annotatedClass":{"@id":"file:/Users/olgagiraldo/Desktop/termsonlyOUT.owl#Distress","@type":"http://www.w3.org/2002/07/owl#Class","links":{"self":"http://data.bioontology.org/ontologies/APAONTO/classes/file%3A%2FUsers%2Folgagiraldo%2FDesktop%2FtermsonlyOUT.owl%23Distress","ontology":"http://data.bioontology.org/ontologies/APAONTO","children":"http://data.bioontology.org/ontologies/APAONTO/classes/file%3A%2FUsers%2Folgagiraldo%2FDesktop%2FtermsonlyOUT.owl%23Distress/children","parents":"http://data.bioontology.org/ontologies/APAONTO/classes/file%3A%2FUsers%2Folgagiraldo%2FDesktop%2FtermsonlyOUT.owl%23Distress/parents","descendants":"http://data.bioontology.org/ontologies/APAONTO/classes/file%3A%2FUsers%2Folgagiraldo%2FDesktop%2FtermsonlyOUT.owl%23Distress/descendants","ancestors":"http://data.bioontology.org/ontologies/APAONTO/classes/file%3A%2FUsers%2Folgagiraldo%2FDesktop%2FtermsonlyOUT.owl%23Distress/ancestors","tree":"http://data.bioontology.org/ontologies/APAONTO/classes/file%3A%2FUsers%2Folgagiraldo%2FDesktop%2FtermsonlyOUT.owl%23Distress/tree","notes":"http://data.bioontology.org/ontologies/APAONTO/classes/file%3A%2FUsers%2Folgagiraldo%2FDesktop%2FtermsonlyOUT.owl%23Distress/notes","mappings":"http://data.bioontology.org/ontologies/APAONTO/classes/file%3A%2FUsers%2Folgagiraldo%2FDesktop%2FtermsonlyOUT.owl%23Distress/mappings","ui":"http://bioportal.bioontology.org/ontologies/APAONTO?p=classes&conceptid=file%3A%2FUsers%2Folgagiraldo%2FDesktop%2FtermsonlyOUT.owl%23Distress","@context":{"self":"http://www.w3.org/2002/07/owl#Class","ontology":"http://data.bioontology.org/metadata/Ontology","children":"http://www.w3.org/2002/07/owl#Class","parents":"http://www.w3.org/2002/07/owl#Class","descendants":"http://www.w3.org/2002/07/owl#Class","ancestors":"http://www.w3.org/2002/07/owl#Class","tree":"http://www.w3.org/2002/07/owl#Class","notes":"http://data.bioontology.org/metadata/Note","mappings":"http://data.bioontology.org/metadata/Mapping","ui":"http://www.w3.org/2002/07/owl#Class"}},"@context":{"@vocab":"http://data.bioontology.org/metadata/"}},"hierarchy":[],"annotations":[{"from":42,"to":49,"matchType":"PREF","text":"DISTRESS"}],"mappings":[]},{"annotatedClass":{"@id":"file:/Users/olgagiraldo/Desktop/termsonlyOUT.owl#PTSD","@type":"http://www.w3.org/2002/07/owl#Class","links":{"self":"http://data.bioontology.org/ontologies/APAONTO/classes/file%3A%2FUsers%2Folgagiraldo%2FDesktop%2FtermsonlyOUT.owl%23PTSD","ontology":"http://data.bioontology.org/ontologies/APAONTO","children":"http://data.bioontology.org/ontologies/APAONTO/classes/file%3A%2FUsers%2Folgagiraldo%2FDesktop%2FtermsonlyOUT.owl%23PTSD/children","parents":"http://data.bioontology.org/ontologies/APAONTO/classes/file%3A%2FUsers%2Folgagiraldo%2FDesktop%2FtermsonlyOUT.owl%23PTSD/parents","descendants":"http://data.bioontology.org/ontologies/APAONTO/classes/file%3A%2FUsers%2Folgagiraldo%2FDesktop%2FtermsonlyOUT.owl%23PTSD/descendants","ancestors":"http://data.bioontology.org/ontologies/APAONTO/classes/file%3A%2FUsers%2Folgagiraldo%2FDesktop%2FtermsonlyOUT.owl%23PTSD/ancestors","tree":"http://data.bioontology.org/ontologies/APAONTO/classes/file%3A%2FUsers%2Folgagiraldo%2FDesktop%2FtermsonlyOUT.owl%23PTSD/tree","notes":"http://data.bioontology.org/ontologies/APAONTO/classes/file%3A%2FUsers%2Folgagiraldo%2FDesktop%2FtermsonlyOUT.owl%23PTSD/notes","mappings":"http://data.bioontology.org/ontologies/APAONTO/classes/file%3A%2FUsers%2Folgagiraldo%2FDesktop%2FtermsonlyOUT.owl%23PTSD/mappings","ui":"http://bioportal.bioontology.org/ontologies/APAONTO?p=classes&conceptid=file%3A%2FUsers%2Folgagiraldo%2FDesktop%2FtermsonlyOUT.owl%23PTSD","@context":{"self":"http://www.w3.org/2002/07/owl#Class","ontology":"http://data.bioontology.org/metadata/Ontology","children":"http://www.w3.org/2002/07/owl#Class","parents":"http://www.w3.org/2002/07/owl#Class","descendants":"http://www.w3.org/2002/07/owl#Class","ancestors":"http://www.w3.org/2002/07/owl#Class","tree":"http://www.w3.org/2002/07/owl#Class","notes":"http://data.bioontology.org/metadata/Note","mappings":"http://data.bioontology.org/metadata/Mapping","ui":"http://www.w3.org/2002/07/owl#Class"}},"@context":{"@vocab":"http://data.bioontology.org/metadata/"}},"hierarchy":[],"annotations":[{"from":80,"to":83,"matchType":"PREF","text":"PTSD"}],"mappings":[]},{"annotatedClass":{"@id":"file:/Users/olgagiraldo/Desktop/termsonlyOUT.owl#Diagnosis","@type":"http://www.w3.org/2002/07/owl#Class","links":{"self":"http://data.bioontology.org/ontologies/APAONTO/classes/file%3A%2FUsers%2Folgagiraldo%2FDesktop%2FtermsonlyOUT.owl%23Diagnosis","ontology":"http://data.bioontology.org/ontologies/APAONTO","children":"http://data.bioontology.org/ontologies/APAONTO/classes/file%3A%2FUsers%2Folgagiraldo%2FDesktop%2FtermsonlyOUT.owl%23Diagnosis/children","parents":"http://data.bioontology.org/ontologies/APAONTO/classes/file%3A%2FUsers%2Folgagiraldo%2FDesktop%2FtermsonlyOUT.owl%23Diagnosis/parents","descendants":"http://data.bioontology.org/ontologies/APAONTO/classes/file%3A%2FUsers%2Folgagiraldo%2FDesktop%2FtermsonlyOUT.owl%23Diagnosis/descendants","ancestors":"http://data.bioontology.org/ontologies/APAONTO/classes/file%3A%2FUsers%2Folgagiraldo%2FDesktop%2FtermsonlyOUT.owl%23Diagnosis/ancestors","tree":"http://data.bioontology.org/ontologies/APAONTO/classes/file%3A%2FUsers%2Folgagiraldo%2FDesktop%2FtermsonlyOUT.owl%23Diagnosis/tree","notes":"http://data.bioontology.org/ontologies/APAONTO/classes/file%3A%2FUsers%2Folgagiraldo%2FDesktop%2FtermsonlyOUT.owl%23Diagnosis/notes","mappings":"http://data.bioontology.org/ontologies/APAONTO/classes/file%3A%2FUsers%2Folgagiraldo%2FDesktop%2FtermsonlyOUT.owl%23Diagnosis/mappings","ui":"http://bioportal.bioontology.org/ontologies/APAONTO?p=classes&conceptid=file%3A%2FUsers%2Folgagiraldo%2FDesktop%2FtermsonlyOUT.owl%23Diagnosis","@context":{"self":"http://www.w3.org/2002/07/owl#Class","ontology":"http://data.bioontology.org/metadata/Ontology","children":"http://www.w3.org/2002/07/owl#Class","parents":"http://www.w3.org/2002/07/owl#Class","descendants":"http://www.w3.org/2002/07/owl#Class","ancestors":"http://www.w3.org/2002/07/owl#Class","tree":"http://www.w3.org/2002/07/owl#Class","notes":"http://data.bioontology.org/metadata/Note","mappings":"http://data.bioontology.org/metadata/Mapping","ui":"http://www.w3.org/2002/07/owl#Class"}},"@context":{"@vocab":"http://data.bioontology.org/metadata/"}},"hierarchy":[],"annotations":[{"from":85,"to":93,"matchType":"PREF","text":"DIAGNOSIS"}],"mappings":[]}]
', 'http://dx.doi.org/10.1037/a0033942', '623063886');
INSERT INTO annotation VALUES ('Rumination as a Mechanism Linking Stressful Life Events to Symptoms of
Depression and Anxiety: Longitudinal Evidence in
Early Adolescents and Adults', 'SYMPTOMS,ANXIETY', '938127b0-643e-49e1-8cf3-9484d8eded86', 'COMPLETED', '2014-05-23 15:03:53.773-05', '2014-05-23 15:03:54.959-05', 49, '[{"annotatedClass":{"@id":"file:/Users/olgagiraldo/Desktop/termsonlyOUT.owl#Symptoms","@type":"http://www.w3.org/2002/07/owl#Class","links":{"self":"http://data.bioontology.org/ontologies/APAONTO/classes/file%3A%2FUsers%2Folgagiraldo%2FDesktop%2FtermsonlyOUT.owl%23Symptoms","ontology":"http://data.bioontology.org/ontologies/APAONTO","children":"http://data.bioontology.org/ontologies/APAONTO/classes/file%3A%2FUsers%2Folgagiraldo%2FDesktop%2FtermsonlyOUT.owl%23Symptoms/children","parents":"http://data.bioontology.org/ontologies/APAONTO/classes/file%3A%2FUsers%2Folgagiraldo%2FDesktop%2FtermsonlyOUT.owl%23Symptoms/parents","descendants":"http://data.bioontology.org/ontologies/APAONTO/classes/file%3A%2FUsers%2Folgagiraldo%2FDesktop%2FtermsonlyOUT.owl%23Symptoms/descendants","ancestors":"http://data.bioontology.org/ontologies/APAONTO/classes/file%3A%2FUsers%2Folgagiraldo%2FDesktop%2FtermsonlyOUT.owl%23Symptoms/ancestors","tree":"http://data.bioontology.org/ontologies/APAONTO/classes/file%3A%2FUsers%2Folgagiraldo%2FDesktop%2FtermsonlyOUT.owl%23Symptoms/tree","notes":"http://data.bioontology.org/ontologies/APAONTO/classes/file%3A%2FUsers%2Folgagiraldo%2FDesktop%2FtermsonlyOUT.owl%23Symptoms/notes","mappings":"http://data.bioontology.org/ontologies/APAONTO/classes/file%3A%2FUsers%2Folgagiraldo%2FDesktop%2FtermsonlyOUT.owl%23Symptoms/mappings","ui":"http://bioportal.bioontology.org/ontologies/APAONTO?p=classes&conceptid=file%3A%2FUsers%2Folgagiraldo%2FDesktop%2FtermsonlyOUT.owl%23Symptoms","@context":{"self":"http://www.w3.org/2002/07/owl#Class","ontology":"http://data.bioontology.org/metadata/Ontology","children":"http://www.w3.org/2002/07/owl#Class","parents":"http://www.w3.org/2002/07/owl#Class","descendants":"http://www.w3.org/2002/07/owl#Class","ancestors":"http://www.w3.org/2002/07/owl#Class","tree":"http://www.w3.org/2002/07/owl#Class","notes":"http://data.bioontology.org/metadata/Note","mappings":"http://data.bioontology.org/metadata/Mapping","ui":"http://www.w3.org/2002/07/owl#Class"}},"@context":{"@vocab":"http://data.bioontology.org/metadata/"}},"hierarchy":[],"annotations":[{"from":60,"to":67,"matchType":"PREF","text":"SYMPTOMS"}],"mappings":[]},{"annotatedClass":{"@id":"file:/Users/olgagiraldo/Desktop/termsonlyOUT.owl#Anxiety","@type":"http://www.w3.org/2002/07/owl#Class","links":{"self":"http://data.bioontology.org/ontologies/APAONTO/classes/file%3A%2FUsers%2Folgagiraldo%2FDesktop%2FtermsonlyOUT.owl%23Anxiety","ontology":"http://data.bioontology.org/ontologies/APAONTO","children":"http://data.bioontology.org/ontologies/APAONTO/classes/file%3A%2FUsers%2Folgagiraldo%2FDesktop%2FtermsonlyOUT.owl%23Anxiety/children","parents":"http://data.bioontology.org/ontologies/APAONTO/classes/file%3A%2FUsers%2Folgagiraldo%2FDesktop%2FtermsonlyOUT.owl%23Anxiety/parents","descendants":"http://data.bioontology.org/ontologies/APAONTO/classes/file%3A%2FUsers%2Folgagiraldo%2FDesktop%2FtermsonlyOUT.owl%23Anxiety/descendants","ancestors":"http://data.bioontology.org/ontologies/APAONTO/classes/file%3A%2FUsers%2Folgagiraldo%2FDesktop%2FtermsonlyOUT.owl%23Anxiety/ancestors","tree":"http://data.bioontology.org/ontologies/APAONTO/classes/file%3A%2FUsers%2Folgagiraldo%2FDesktop%2FtermsonlyOUT.owl%23Anxiety/tree","notes":"http://data.bioontology.org/ontologies/APAONTO/classes/file%3A%2FUsers%2Folgagiraldo%2FDesktop%2FtermsonlyOUT.owl%23Anxiety/notes","mappings":"http://data.bioontology.org/ontologies/APAONTO/classes/file%3A%2FUsers%2Folgagiraldo%2FDesktop%2FtermsonlyOUT.owl%23Anxiety/mappings","ui":"http://bioportal.bioontology.org/ontologies/APAONTO?p=classes&conceptid=file%3A%2FUsers%2Folgagiraldo%2FDesktop%2FtermsonlyOUT.owl%23Anxiety","@context":{"self":"http://www.w3.org/2002/07/owl#Class","ontology":"http://data.bioontology.org/metadata/Ontology","children":"http://www.w3.org/2002/07/owl#Class","parents":"http://www.w3.org/2002/07/owl#Class","descendants":"http://www.w3.org/2002/07/owl#Class","ancestors":"http://www.w3.org/2002/07/owl#Class","tree":"http://www.w3.org/2002/07/owl#Class","notes":"http://data.bioontology.org/metadata/Note","mappings":"http://data.bioontology.org/metadata/Mapping","ui":"http://www.w3.org/2002/07/owl#Class"}},"@context":{"@vocab":"http://data.bioontology.org/metadata/"}},"hierarchy":[],"annotations":[{"from":87,"to":93,"matchType":"PREF","text":"ANXIETY"}],"mappings":[]}]
', 'http://dx.doi.org/10.1037/a0031994', '623063886');


--
-- Name: annotation_id_seq; Type: SEQUENCE SET; Schema: public; Owner: nanotate
--

SELECT pg_catalog.setval('annotation_id_seq', 50, true);


--
-- Name: annotation_user_name_seq; Type: SEQUENCE SET; Schema: public; Owner: nanotate
--

SELECT pg_catalog.setval('annotation_user_name_seq', 46, true);


--
-- Data for Name: document; Type: TABLE DATA; Schema: public; Owner: nanotate
--

INSERT INTO document VALUES ('5d965ff2-b7d0-4025-b36e-e611d500b62d', 'http://dx.doi.org/10.1037/a0033942', 'Psychophysiologic reactivity, subjective distress, and their associations with PTSD diagnosis.', 'Suzanne L. Pineles, Michael K. Suvak, Gabrielle I. Liverant, Kristin Gregor, Blair E. Wisco, Roger K. Pitman, Scott P. Orr, 2013, ''Psychophysiologic reactivity, subjective distress, and their associations with PTSD diagnosis.'', <i>Journal of Abnormal Psychology</i>, vol. 122, no. 3, pp. 635-644', 2013);
INSERT INTO document VALUES ('938127b0-643e-49e1-8cf3-9484d8eded86', 'http://dx.doi.org/10.1037/a0031994', 'Rumination as a mechanism linking stressful life events to symptoms of depression and anxiety: Longitudinal evidence in early adolescents and adults.', 'Louisa C. Michl, Katie A. McLaughlin, Kathrine Shepherd, Susan Nolen-Hoeksema, 2013, ''Rumination as a mechanism linking stressful life events to symptoms of depression and anxiety: Longitudinal evidence in early adolescents and adults.'', <i>Journal of Abnormal Psychology</i>, vol. 122, no. 2, pp. 339-352', 2013);
INSERT INTO document VALUES ('a02af22f-cb03-49a1-b55e-6c280df2ec76', 'http://dx.doi.org/10.1037/a0032733', 'Distinguishing Healthy Adults From People With Social Anxiety Disorder: Evidence for the Value of Experiential Avoidance and Positive Emotions in Everyday Social Interactions.', 'Todd B. Kashdan, Antonina S. Farmer, Leah M. Adams, Patty Ferssizidis, Patrick E. McKnight, John B. Nezlek, 2013, ''Distinguishing Healthy Adults From People With Social Anxiety Disorder: Evidence for the Value of Experiential Avoidance and Positive Emotions in Everyday Social Interactions.'', <i>Journal of Abnormal Psychology</i>', 2013);
INSERT INTO document VALUES ('3e8a2936-a374-4a12-8c20-83682a729e76', 'http://dx.doi.org/10.1037/a0030584', 'Review of Innovation, technology, psychology: A review of technology innovations for behavioral education.', 'Frank Farley, 2013, ''Review of Innovation, technology, psychology: A review of technology innovations for behavioral education.'', <i>Psychology of Aesthetics, Creativity, and the Arts</i>, vol. 7, no. 2, pp. 210-211', 2013);
INSERT INTO document VALUES ('9652cabc-e17b-4489-a00e-aea23d8a031d', 'http://dx.doi.org/10.1037/a0031737', 'Perceptions of partners��� problematic alcohol use affect relationship outcomes beyond partner self-reported drinking: Alcohol use in committed romantic relationships.', 'Lindsey M. Rodriguez, Camilla S. ��verup, Clayton Neighbors, 2013, ''Perceptions of partners��� problematic alcohol use affect relationship outcomes beyond partner self-reported drinking: Alcohol use in committed romantic relationships.'', <i>Psychology of Addictive Behaviors</i>, vol. 27, no. 3, pp. 627-638', 2013);
INSERT INTO document VALUES ('164b5634-23c5-435b-a306-fd99b99ecacf', 'http://dx.doi.org/10.1027/2192-0923/a000027', 'Developing a Single-Pilot Line Operations Safety Audit', 'Laurie Earl, Paul R. Bates, Patrick S. Murray, A. Ian Glendon, Peter A. Creed, 2012, ''Developing a Single-Pilot Line Operations Safety Audit'', <i>Aviation Psychology and Applied Human Factors</i>, vol. 2, no. 2, pp. 49-61', 2012);
INSERT INTO document VALUES ('782c0a38-2889-4c51-b92f-33e08767a15a', 'http://dx.doi.org/10.1037/a0033656', 'Can���t get it out of my mind: Employee rumination after customer mistreatment and negative mood in the next morning.', 'Mo Wang, Songqi Liu, Hui Liao, Yaping Gong, John Kammeyer-Mueller, Junqi Shi, 2013, ''Can���t get it out of my mind: Employee rumination after customer mistreatment and negative mood in the next morning.'', <i>Journal of Applied Psychology</i>, vol. 98, no. 6, pp. 989-1004', 2013);
INSERT INTO document VALUES ('b728db61-44a1-434c-9e39-00148af2c54f', 'http://dx.doi.org/10.1037/a0033656', 'Can���t get it out of my mind: Employee rumination after customer mistreatment and negative mood in the next morning.', 'Mo Wang, Songqi Liu, Hui Liao, Yaping Gong, John Kammeyer-Mueller, Junqi Shi, 2013, ''Can���t get it out of my mind: Employee rumination after customer mistreatment and negative mood in the next morning.'', <i>Journal of Applied Psychology</i>, vol. 98, no. 6, pp. 989-1004', 2013);
INSERT INTO document VALUES ('8e8627fd-f5d8-46a5-b00e-930d99a8cf8f', 'http://dx.doi.org/10.1037/a0033656', 'Can���t get it out of my mind: Employee rumination after customer mistreatment and negative mood in the next morning.', 'Mo Wang, Songqi Liu, Hui Liao, Yaping Gong, John Kammeyer-Mueller, Junqi Shi, 2013, ''Can���t get it out of my mind: Employee rumination after customer mistreatment and negative mood in the next morning.'', <i>Journal of Applied Psychology</i>, vol. 98, no. 6, pp. 989-1004', 2013);
INSERT INTO document VALUES ('ddc1aa3b-40c1-4224-bc7b-42b639340ca3', 'http://dx.doi.org/10.1037/a0033656', 'Can���t get it out of my mind: Employee rumination after customer mistreatment and negative mood in the next morning.', 'Mo Wang, Songqi Liu, Hui Liao, Yaping Gong, John Kammeyer-Mueller, Junqi Shi, 2013, ''Can���t get it out of my mind: Employee rumination after customer mistreatment and negative mood in the next morning.'', <i>Journal of Applied Psychology</i>, vol. 98, no. 6, pp. 989-1004', 2013);
INSERT INTO document VALUES ('0960ae53-9b0b-4d6b-9b5e-f71e55ccc55d', 'http://dx.doi.org/10.1037/a0033656', 'Can���t get it out of my mind: Employee rumination after customer mistreatment and negative mood in the next morning.', 'Mo Wang, Songqi Liu, Hui Liao, Yaping Gong, John Kammeyer-Mueller, Junqi Shi, 2013, ''Can���t get it out of my mind: Employee rumination after customer mistreatment and negative mood in the next morning.'', <i>Journal of Applied Psychology</i>, vol. 98, no. 6, pp. 989-1004', 2013);
INSERT INTO document VALUES ('c0471549-6650-4a2c-8ddb-d3ded31848d5', 'http://dx.doi.org/10.1037/a0033656', 'Can���t get it out of my mind: Employee rumination after customer mistreatment and negative mood in the next morning.', 'Mo Wang, Songqi Liu, Hui Liao, Yaping Gong, John Kammeyer-Mueller, Junqi Shi, 2013, ''Can���t get it out of my mind: Employee rumination after customer mistreatment and negative mood in the next morning.'', <i>Journal of Applied Psychology</i>, vol. 98, no. 6, pp. 989-1004', 2013);
INSERT INTO document VALUES ('f3b10c50-b615-4480-ae7e-bf9f2fcda807', 'http://dx.doi.org/10.1037/a0033656', 'Can���t get it out of my mind: Employee rumination after customer mistreatment and negative mood in the next morning.', 'Mo Wang, Songqi Liu, Hui Liao, Yaping Gong, John Kammeyer-Mueller, Junqi Shi, 2013, ''Can���t get it out of my mind: Employee rumination after customer mistreatment and negative mood in the next morning.'', <i>Journal of Applied Psychology</i>, vol. 98, no. 6, pp. 989-1004', 2013);
INSERT INTO document VALUES ('982a925a-8f65-4be8-a753-50893192f0db', 'http://dx.doi.org/10.1037/a0033656', 'Can���t get it out of my mind: Employee rumination after customer mistreatment and negative mood in the next morning.', 'Mo Wang, Songqi Liu, Hui Liao, Yaping Gong, John Kammeyer-Mueller, Junqi Shi, 2013, ''Can���t get it out of my mind: Employee rumination after customer mistreatment and negative mood in the next morning.'', <i>Journal of Applied Psychology</i>, vol. 98, no. 6, pp. 989-1004', 2013);


--
-- Data for Name: user; Type: TABLE DATA; Schema: public; Owner: nanotate
--

INSERT INTO "user" VALUES ('admin', 'password', NULL, NULL, NULL, NULL, NULL, NULL);


--
-- Name: annotation_pkey; Type: CONSTRAINT; Schema: public; Owner: nanotate; Tablespace: 
--

ALTER TABLE ONLY annotation
    ADD CONSTRAINT annotation_pkey PRIMARY KEY (id);


--
-- Name: document_pkey; Type: CONSTRAINT; Schema: public; Owner: nanotate; Tablespace: 
--

ALTER TABLE ONLY document
    ADD CONSTRAINT document_pkey PRIMARY KEY (uuid);


--
-- Name: user_pkey; Type: CONSTRAINT; Schema: public; Owner: nanotate; Tablespace: 
--

ALTER TABLE ONLY "user"
    ADD CONSTRAINT user_pkey PRIMARY KEY (username);


--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

